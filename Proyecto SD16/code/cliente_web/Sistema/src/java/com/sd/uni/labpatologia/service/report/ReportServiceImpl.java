package com.sd.uni.labpatologia.service.report;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.report.ReportB;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.rest.report.IReportResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import com.sd.uni.labpatologia.service.request.IRequestService;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

@Service("reportService")
public class ReportServiceImpl extends BaseServiceImpl<ReportB, ReportDTO>
		implements IReportService {

	@Autowired
	private IReportResource _reportResource;
	@Autowired
	private IRequestService _requestService;

	public ReportServiceImpl() {
	}

	@Override
	public ReportB save(ReportB bean) {
		final ReportDTO report = convertBeanToDto(bean);
		final ReportDTO dto = _reportResource.save(report);
		final ReportB reportB = convertDtoToBean(dto);
		return reportB;
	}

	@Override
	public List<ReportB> getAll() {
		final ReportResult result = _reportResource.getAll();
		final List<ReportDTO> rList = null == result.getReports() ? new ArrayList<ReportDTO>()
				: result.getReports();

		final List<ReportB> reports = new ArrayList<ReportB>();
		for (ReportDTO dto : rList) {
			final ReportB bean = convertDtoToBean(dto);
			reports.add(bean);
		}
		return reports;
	}

	@Override
	public ReportB getById(Integer id) {
		final ReportDTO dto = _reportResource.getById(id);
		final ReportB bean = convertDtoToBean(dto);
		return bean;
	}

	@Override
	protected ReportB convertDtoToBean(ReportDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("observations", dto.getObservations());
		final ReportB reportB = new ReportB(params);
		reportB.setDiagnostic(dto.getDiagnostic());
		reportB.setDate(dto.getDate());
		reportB.setRequest(_requestService.getById(dto.getRequestId()));

		return reportB;
	}

	@Override
	protected ReportDTO convertBeanToDto(ReportB bean) {
		final ReportDTO dto = new ReportDTO();
		dto.setId(bean.getId());
		dto.setDate(bean.getDate());
		dto.setDiagnostic(bean.getDiagnostic());
		dto.setObservations(bean.getObservations());
		dto.setRequestId(bean.getRequest().getId());
		return dto;
	}
	@Override
	public List<ReportB> find (String textToFind) {
		final ReportResult result = _reportResource.find(textToFind);
		final List<ReportDTO> rList = null == result.getReports() ? new ArrayList<ReportDTO>()
				: result.getReports();

		final List<ReportB> reports = new ArrayList<ReportB>();
		for (ReportDTO dto : rList) {
			final ReportB bean = convertDtoToBean(dto);
			reports.add(bean);
		}
		return reports;
	}
}
