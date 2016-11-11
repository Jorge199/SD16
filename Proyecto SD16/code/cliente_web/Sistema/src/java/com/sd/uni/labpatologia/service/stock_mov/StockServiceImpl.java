package com.sd.uni.labpatologia.service.stock_mov;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.stock_mov.Stock_movB;
import com.sd.uni.labpatologia.dto.stock_mov.StockDTO;
import com.sd.uni.labpatologia.dto.stock_mov.StockResult;
import com.sd.uni.labpatologia.rest.stock_mov.IStockResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service("stockService")
public class StockServiceImpl extends BaseServiceImpl<Stock_movB, StockDTO> implements IStockService{
	@Autowired
	private IStockResource _stockResource;
	
	public StockServiceImpl() {
		
	}
	@Override
	public Stock_movB save(Stock_movB bean) {
		final StockDTO stmv = convertBeanToDto(bean);
		final StockDTO dto = _stockResource.save(stmv);
		final Stock_movB Stock_movB = convertDtoToBean(dto);
		return Stock_movB;
	}

	@Override
	public List<Stock_movB> getAll() {
		final StockResult result = _stockResource.getAll();
		final List<StockDTO> stList = null == result.getStocks() ? new ArrayList<StockDTO>()
				: result.getStocks();

		final List<Stock_movB> laboratories = new ArrayList<Stock_movB>();
		for (StockDTO dto : stList) {
			final Stock_movB bean = convertDtoToBean(dto);
			laboratories.add(bean);
		}
		return laboratories;
	}

	@Override
	public Stock_movB getById(Integer id) {
		final StockDTO dto = _stockResource.getById(id);
		final Stock_movB bean = convertDtoToBean(dto);

		return bean;
	}

	@Override
	protected Stock_movB convertDtoToBean(StockDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("count", String.valueOf(dto.getCount()));
		params.put("date", dto.getDate().toString());
		params.put("mov_type", String.valueOf(dto.getMovtype()));
		params.put("_article_id", String.valueOf(dto.getArticleId()));
		final Stock_movB stB = new Stock_movB(params);
		return stB;
	}

	@Override
	protected StockDTO convertBeanToDto(Stock_movB bean) {
		final StockDTO dto = new StockDTO();
		dto.setId(bean.getId());
		dto.setCount(bean.getCount());
		dto.setDate(bean.getDate());
		dto.setMovtype(bean.getMovtype());

		return dto;
	}

	@Override
	public List<Stock_movB> find(String textToFind, int maxItems, int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
