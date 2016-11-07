package com.sd.uni.labpatologia.rest.report;

import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

public interface IReportResource extends IBaseResource<ReportDTO> {

	public ReportResult getAll();
	public ReportResult find(String textToFind);
}
