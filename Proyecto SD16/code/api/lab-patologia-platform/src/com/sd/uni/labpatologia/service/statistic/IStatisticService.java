package com.sd.uni.labpatologia.service.statistic;

import com.sd.uni.labpatologia.dao.statistic.StatisticDaoImpl;
import com.sd.uni.labpatologia.domain.statistic.StatisticDomain;
import com.sd.uni.labpatologia.dto.statistic.StatisticDTO;
import com.sd.uni.labpatologia.dto.statistic.StatisticResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IStatisticService extends IBaseService<StatisticDTO, StatisticDomain, StatisticDaoImpl, StatisticResult> {

	StatisticResult find(String textToFind) throws PatologyException;
	
}