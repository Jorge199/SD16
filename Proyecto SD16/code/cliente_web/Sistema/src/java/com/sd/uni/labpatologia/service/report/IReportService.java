package com.sd.uni.labpatologia.service.report;

import java.util.List;

import com.sd.uni.labpatologia.beans.report.ReportB;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IReportService extends IBaseService<ReportB, ReportDTO> {
	public List <ReportB> find(String textToFind);
}
