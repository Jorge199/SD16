package com.sd.uni.labpatologia.dao.report;

import java.util.List;

import com.sd.uni.labpatologia.dao.base.IBaseDao;
import com.sd.uni.labpatologia.domain.report.ReportDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

public interface IReportDao extends IBaseDao<ReportDomain> {
	public List<ReportDomain>find(String textToFind) throws PatologyException;
}
