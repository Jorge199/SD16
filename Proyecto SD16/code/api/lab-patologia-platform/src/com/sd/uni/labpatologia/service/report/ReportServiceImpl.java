package com.sd.uni.labpatologia.service.report;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.report.IReportDao;
import com.sd.uni.labpatologia.dao.report.ReportDaoImpl;
import com.sd.uni.labpatologia.domain.report.ReportDomain;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class ReportServiceImpl extends BaseServiceImpl<ReportDTO, ReportDomain, ReportDaoImpl, ReportResult>
		implements IReportService {
	@Autowired
	private IReportDao reportDao;

	@Override
	@Transactional
	public ReportDTO save(ReportDTO dto) {
		final ReportDomain domain = convertDtoToDomain(dto);
		final ReportDomain reportDomain = reportDao.save(domain);
		return convertDomainToDto(reportDomain);
	}

	@Override
	@Transactional
	public ReportDTO getById(Integer id) {
		final ReportDomain domain = reportDao.getById(id);
		final ReportDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
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
		dto.setIdDoctor(domain.getIdDoctor());
		dto.setIdPaciente(domain.getIdPaciente());
		dto.setIdEstudio(domain.getIdEstudio());
		dto.setDiagnostico(domain.getDiagnostico());
		dto.setFecha(domain.getFecha());
		dto.setObservaciones(domain.getObservaciones());
		return dto;
	}

	@Override
	protected ReportDomain convertDtoToDomain(ReportDTO dto) {
		final ReportDomain domain = new ReportDomain();
		domain.setId(dto.getId());
		domain.setIdDoctor(dto.getIdDoctor());
		domain.setIdPaciente(dto.getIdPaciente());
		domain.setIdEstudio(dto.getIdEstudio());
		domain.setDiagnostico(dto.getDiagnostico());
		domain.setFecha(dto.getFecha());
		domain.setObservaciones(dto.getObservaciones());
		return domain;
	}

	@Override
	@Transactional
	public ReportResult find(String textToFind) {
		final List<ReportDTO> reports = new ArrayList<>();
		for (ReportDomain domain : reportDao.find(textToFind)) {
			final ReportDTO dto = convertDomainToDto(domain);
			reports.add(dto);
		}
		final ReportResult reportResult = new ReportResult();
		reportResult.setReports(reports);
		return reportResult;
	}

}
