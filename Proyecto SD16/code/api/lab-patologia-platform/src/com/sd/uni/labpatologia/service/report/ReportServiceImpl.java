package com.sd.uni.labpatologia.service.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.report.IReportDao;
import com.sd.uni.labpatologia.dao.report.ReportDaoImpl;
import com.sd.uni.labpatologia.dao.request.IRequestDao;
import com.sd.uni.labpatologia.domain.report.ReportDomain;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class ReportServiceImpl extends BaseServiceImpl<ReportDTO, ReportDomain, ReportDaoImpl, ReportResult>
		implements IReportService {
	@Autowired
	private IReportDao reportDao;
	
	@Autowired
	private IRequestDao requestDao;

	@Override
	@Transactional
	@CacheEvict(value= "lab-patologia-platform-cache",key = "'reports'")
	@CachePut(value = "lab-patologia-platform-cache", key = "'report_' + #dto.id", condition="#dto.id!=null")
	public ReportDTO save(ReportDTO dto) {
		final ReportDomain domain = convertDtoToDomain(dto);
		final ReportDomain report = reportDao.save(domain);
		final ReportDTO newDto = convertDomainToDto(report);
		if (dto.getId() == null) {
			getCacheManager().getCache("lab-patologia-platform-cache").put("report_" + report.getId(), newDto);
		}
		return newDto;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "lab-patologia-platform-cache", key = "'report_' + #id")
	public ReportDTO getById(Integer id) throws PatologyException {
		final ReportDomain domain = reportDao.getById(id);
		final ReportDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "lab-patologia-platform-cache", key = "'reports'")
	public ReportResult getAll() {
		final List<ReportDTO> reports = new ArrayList<>();
		for (ReportDomain domain : reportDao.findAll()) {
			final ReportDTO dto = convertDomainToDto(domain);
			reports.add(dto);
		}
		final ReportResult reportResult = new ReportResult();
		reportResult.setReports(reports);
		return reportResult;
	}

	@Override
	protected ReportDTO convertDomainToDto(ReportDomain domain) {
		final ReportDTO dto = new ReportDTO();
		dto.setId(domain.getId());
		dto.setRequestId(domain.getRequest().getId());
		dto.setDiagnostic(domain.getDiagnostic());
		dto.setDate(domain.getDate());
		dto.setObservations(domain.getObservations());
		return dto;
	}

	@Override
	protected ReportDomain convertDtoToDomain(ReportDTO dto) {
		final ReportDomain domain = new ReportDomain();
		domain.setId(dto.getId());
		try {
			domain.setRequest(requestDao.getById(dto.getRequestId()));
		} catch (PatologyException e) {
			e.printStackTrace();
		}
		domain.setDiagnostic(dto.getDiagnostic());
		domain.setDate(dto.getDate());
		domain.setObservations(dto.getObservations());
		return domain;
	}

	@Override
	@Transactional(readOnly = true)
	public ReportResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<ReportDTO> reports = new ArrayList<>();
		for (ReportDomain domain : reportDao.find(textToFind, page, maxItems)) {
			final ReportDTO dto = convertDomainToDto(domain);
			reports.add(dto);
		}
		final ReportResult reportResult = new ReportResult();
		reportResult.setReports(reports);
		return reportResult;
	}

}
