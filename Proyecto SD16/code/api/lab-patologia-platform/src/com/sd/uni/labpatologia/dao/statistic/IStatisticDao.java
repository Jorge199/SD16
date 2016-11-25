package com.sd.uni.labpatologia.dao.statistic;

import java.util.List;

import com.sd.uni.labpatologia.dao.base.IBaseDao;
import com.sd.uni.labpatologia.domain.statistic.StatisticDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

public interface IStatisticDao extends IBaseDao<StatisticDomain> {
	public abstract List<StatisticDomain>find(String textToFind) throws PatologyException;;
}
