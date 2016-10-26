package com.sd.uni.labpatologia.dao.report;

import java.util.List;

import com.sd.uni.labpatologia.dao.base.IBaseDao;
import com.sd.uni.labpatologia.domain.report.ReportDomain;

public interface IReportDao extends IBaseDao<ReportDomain> {
	public List<ReportDomain>find(String textToFind);
}
