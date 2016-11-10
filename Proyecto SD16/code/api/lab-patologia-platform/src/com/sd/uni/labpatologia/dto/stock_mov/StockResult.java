package com.sd.uni.labpatologia.dto.stock_mov;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;

@XmlRootElement(name = "stockResult")
public class StockResult extends BaseResult<StockDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<StockDTO> getStocks() {
		return getList();
	}

	public void setStocks(List<StockDTO> dtos) {
		super.setList(dtos);
	}
}