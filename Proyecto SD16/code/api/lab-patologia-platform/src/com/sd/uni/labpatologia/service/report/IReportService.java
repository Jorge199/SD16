package com.sd.uni.labpatologia.service.report;

import com.sd.uni.labpatologia.dao.report.ReportDaoImpl;
import com.sd.uni.labpatologia.domain.report.ReportDomain;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IReportService extends IBaseService<ReportDTO, ReportDomain, ReportDaoImpl, ReportResult> {
	
}
