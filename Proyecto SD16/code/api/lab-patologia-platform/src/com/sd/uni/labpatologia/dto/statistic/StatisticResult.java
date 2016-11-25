package com.sd.uni.labpatologia.dto.statistic;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;

@XmlRootElement(name = "statisticResult")
public class StatisticResult extends BaseResult<StatisticDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<StatisticDTO> getStatistics() {
		return getList();
	}

	public void setStatistics(List<StatisticDTO> dtos) {
		super.setList(dtos);
	}
}
