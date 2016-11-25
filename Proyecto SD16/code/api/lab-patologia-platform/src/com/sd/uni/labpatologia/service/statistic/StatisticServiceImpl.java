package com.sd.uni.labpatologia.service.statistic;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.statistic.IStatisticDao;
import com.sd.uni.labpatologia.dao.statistic.StatisticDaoImpl;
import com.sd.uni.labpatologia.domain.statistic.StatisticDomain;
import com.sd.uni.labpatologia.dto.statistic.StatisticDTO;
import com.sd.uni.labpatologia.dto.statistic.StatisticResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class StatisticServiceImpl extends
		BaseServiceImpl<StatisticDTO, StatisticDomain, StatisticDaoImpl, StatisticResult> implements IStatisticService {
	@Autowired
	private IStatisticDao _statisticDao;

	private static Logger logger = Logger.getLogger(StatisticServiceImpl.class);

	@Override
	@Transactional
	// @CacheEvict(value= "lab-patologia-platform-cache",key = "'requests'")
	// @CachePut(value = "lab-patologia-platform-cache", key = "'request_' +
	// #dto.id", condition="#dto.id!=null")
	public StatisticDTO save(StatisticDTO dto) {
		try {
			// Lanzo exepcion de tipo runtime para realizar rollback
			final StatisticDomain domain = convertDtoToDomain(dto);
			final StatisticDomain statistic = _statisticDao.save(domain);
			final StatisticDTO newDto = convertDomainToDto(statistic);
			// if (dto.getId() == null) {
			// getCacheManager().getCache("lab-patologia-platform-cache").put("request_"
			// + request.getId(), newDto);
			// }
			return newDto;
		} catch (PatologyException ex) {
			logger.error(ex);
			throw new RuntimeException("Error" + StatisticServiceImpl.class + "" + ex.getMessage(), ex);
		}

	}

	@Override
	@Transactional(readOnly = true)
	// @Cacheable(value = "lab-patologia-platform-cache", key = "'request_' +
	// #id")
	public StatisticDTO getById(Integer id) throws PatologyException {
		final StatisticDomain domain = _statisticDao.getById(id);
		final StatisticDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	// @Cacheable(value = "lab-patologia-platform-cache", key = "'requests'")
	public StatisticResult getAll() {
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
		dto.setDate(domain.getDate());
		dto.setSex(domain.getSex());
		dto.setDiagnostic(domain.getDiagnostic());
		dto.setPatientAge(domain.getPatientAge());
		return dto;
	}

	@Override
	protected StatisticDomain convertDtoToDomain(StatisticDTO dto) throws PatologyException {
		final StatisticDomain domain = new StatisticDomain();
		domain.setDate(dto.getDate());
		domain.setDiagnostic(dto.getDiagnostic());
		domain.setPatientAge(dto.getPatientAge());
		domain.setSex(dto.getSex());
		return domain;
	}

	@Override
	@Transactional(readOnly = true)
	public StatisticResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<StatisticDTO> statistics = new ArrayList<>();
		for (StatisticDomain domain : _statisticDao.find(textToFind, page, maxItems)) {
			final StatisticDTO dto = convertDomainToDto(domain);
			statistics.add(dto);
		}
		final StatisticResult statisticResult = new StatisticResult();
		statisticResult.setStatistics(statistics);
		return statisticResult;
	}

}
