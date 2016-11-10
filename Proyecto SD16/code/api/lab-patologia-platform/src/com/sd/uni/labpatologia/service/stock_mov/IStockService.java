package com.sd.uni.labpatologia.service.stock_mov;

import com.sd.uni.labpatologia.dao.stock_mov.StockDaoImpl;
import com.sd.uni.labpatologia.domain.stock_mov.StockDomain;
import com.sd.uni.labpatologia.dto.stock_mov.StockDTO;
import com.sd.uni.labpatologia.dto.stock_mov.StockResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IStockService extends IBaseService<StockDTO, StockDomain, StockDaoImpl, StockResult> {
	public StockResult find(String textToFind) throws PatologyException;
}