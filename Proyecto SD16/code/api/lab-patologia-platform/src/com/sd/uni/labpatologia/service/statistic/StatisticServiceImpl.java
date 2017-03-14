package com.sd.uni.labpatologia.service.statistic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.diagnostic.IDiagnosticDao;
import com.sd.uni.labpatologia.dao.doctor.IDoctorDao;
import com.sd.uni.labpatologia.dao.statistic.IStatisticDao;
import com.sd.uni.labpatologia.dao.statistic.StatisticDaoImpl;
import com.sd.uni.labpatologia.domain.statistic.StatisticDomain;
import com.sd.uni.labpatologia.dto.statistic.StatisticDTO;
import com.sd.uni.labpatologia.dto.statistic.StatisticResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import com.sd.uni.labpatologia.service.scheduling.StatisticBatchService;

@Service
public class StatisticServiceImpl extends
		BaseServiceImpl<StatisticDTO, StatisticDomain, StatisticDaoImpl, StatisticResult> implements IStatisticService {
	@Autowired
	private IStatisticDao _statisticDao;

	@Autowired
	private StatisticBatchService _statisticBatchService;
	@Autowired
	private IDiagnosticDao _diagnosticDao;
	
	private static Logger logger = Logger.getLogger(StatisticServiceImpl.class);

	@Override
	@Transactional
	@CachePut(value = "lab-patologia-platform-cache", key = "'statistic_' + #dto.id", condition = "#dto.id!=null")
	public StatisticDTO save(StatisticDTO dto) {
		try {
			// Lanzo exepcion de tipo runtime para realizar rollback
			final StatisticDomain domain = convertDtoToDomain(dto);
			final StatisticDomain statistic = _statisticDao.save(domain);
			final StatisticDTO newDto = convertDomainToDto(statistic);
			if (dto.getId() == null) {
				getCacheManager().getCache("lab-patologia-platform-cache").put("statistic_" + statistic.getId(),
						newDto);
			}
			return newDto;
		} catch (PatologyException ex) {
			logger.error(ex);
			throw new RuntimeException("Error" + StatisticServiceImpl.class + "" + ex.getMessage(), ex);
		}

	}

	@Override
	@Transactional
	@Cacheable(value = "lab-patologia-platform-cache", key = "'statistic_' + #id")
	public StatisticDTO getById(Integer id) throws PatologyException {
		final StatisticDomain domain = _statisticDao.getById(id);
		final StatisticDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	public StatisticResult getAll() throws PatologyException {
		_statisticBatchService.calculateStatistics();

		final List<StatisticDTO> statistics = new ArrayList<>();
		for (StatisticDomain domain : _statisticDao.findAll()) {
			final StatisticDTO dto = convertDomainToDto(domain);
			statistics.add(dto);
		}
		final StatisticResult statisticResult = new StatisticResult();
		statisticResult.setStatistics(statistics);
		return statisticResult;
	}

	@Override
	protected StatisticDTO convertDomainToDto(StatisticDomain domain) {
		final StatisticDTO dto = new StatisticDTO();
		dto.setId(domain.getId());
		dto.setDate(domain.getDate());
		dto.setSex(domain.getSex());
		dto.setDiagnosticId(domain.getDiagnostic().getId());
		dto.setPatientAge(domain.getPatientAge());
		return dto;
	}

	@Override
	protected StatisticDomain convertDtoToDomain(StatisticDTO dto) throws PatologyException {
		final StatisticDomain domain = new StatisticDomain();
		domain.setId(dto.getId());
		domain.setDate(dto.getDate());
		domain.setDiagnostic(_diagnosticDao.getById(dto.getDiagnosticId()));
		domain.setPatientAge(dto.getPatientAge());
		domain.setSex(dto.getSex());
		return domain;
	}

	@Override
	@Transactional
	public StatisticResult find(String textToFind, int page, int maxItems) throws PatologyException {
		_statisticBatchService.calculateStatistics();
		final List<StatisticDTO> statistics = new ArrayList<>();
		for (StatisticDomain domain : _statisticDao.find(textToFind, page, maxItems)) {
			final StatisticDTO dto = convertDomainToDto(domain);
			statistics.add(dto);
		}
		final StatisticResult statisticResult = new StatisticResult();
		statisticResult.setStatistics(statistics);
		return statisticResult;
	}

	@Override
	@Transactional
	public StatisticResult find(String textToFind) throws PatologyException {
		_statisticBatchService.calculateStatistics();
		final List<StatisticDTO> statistics = new ArrayList<>();
		for (StatisticDomain domain : _statisticDao.find(textToFind)) {
			final StatisticDTO dto = convertDomainToDto(domain);
			statistics.add(dto);
		}
		final StatisticResult statisticResult = new StatisticResult();
		statisticResult.setStatistics(statistics);
		return statisticResult;
	}

}
