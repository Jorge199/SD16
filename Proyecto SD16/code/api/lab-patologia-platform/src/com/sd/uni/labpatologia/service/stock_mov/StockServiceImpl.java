package com.sd.uni.labpatologia.service.stock_mov;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.article.IArticleDao;
import com.sd.uni.labpatologia.dao.stock_mov.IStockDao;
import com.sd.uni.labpatologia.dao.stock_mov.StockDaoImpl;
import com.sd.uni.labpatologia.domain.stock_mov.StockDomain;
import com.sd.uni.labpatologia.dto.stock_mov.StockDTO;
import com.sd.uni.labpatologia.dto.stock_mov.StockResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class StockServiceImpl extends BaseServiceImpl<StockDTO, StockDomain, StockDaoImpl, StockResult>
		implements IStockService {
	@Autowired
	private IStockDao stockDao;
		
	@Autowired
	private IArticleDao articleDao;


	@Override
	@Transactional
	@CachePut(value = "lab-patologia-platform-cache")
	public StockDTO save(StockDTO dto) {
		final StockDomain domain = convertDtoToDomain(dto);
		final StockDomain stockDomain = stockDao.save(domain);
		return convertDomainToDto(stockDomain);
	}

	@Override
	@Transactional
	@Cacheable(value = "lab-patologia-platform-cache", key = "'stock_' + #id")
	public StockDTO getById(Integer id) throws PatologyException {
		final StockDomain domain = stockDao.getById(id);
		final StockDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	@Cacheable(value = "lab-patologia-platform-cache")
	public StockResult getAll() {
		final List<StockDTO> stocks = new ArrayList<>();
		for (StockDomain domain : stockDao.findAll()) {
			final StockDTO dto = convertDomainToDto(domain);
			stocks.add(dto);
		}
		final StockResult stockResult = new StockResult();
		stockResult.setStocks(stocks);
		return stockResult;
	}

	@Override
	protected StockDTO convertDomainToDto(StockDomain domain) {
		final StockDTO dto = new StockDTO();
		dto.setId(domain.getId());
		if (null != domain.getArticle()) dto.setArticleId(domain.getArticle().getId());
		if (null != domain.getCount()) dto.setCount(domain.getCount());
		if (null != domain.getMovtype()) dto.setMovtype(domain.getMovtype());
		if (null != domain.getDate()) dto.setDate(domain.getDate());
		return dto;
	}

	@Override
	protected StockDomain convertDtoToDomain(StockDTO dto) {
		final StockDomain domain = new StockDomain();
		domain.setId(dto.getId());
		try {
			if (null != dto.getArticleId()) domain.setArticle(articleDao.getById(dto.getArticleId()) );
		} catch (PatologyException e) {
			e.printStackTrace();
		}
		if (null != dto.getCount()) domain.setCount(dto.getCount());
		if (null != dto.getMovtype()) domain.setMovtype(dto.getMovtype());
		if (null != dto.getDate()) domain.setDate(dto.getDate());

		return domain;
	}

	@Override
	@Transactional
	public StockResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<StockDTO> stocks = new ArrayList<>();
		for (StockDomain domain : stockDao.find(textToFind,page,maxItems)) {
			final StockDTO dto = convertDomainToDto(domain);
			stocks.add(dto);
		}
		final StockResult stockResult = new StockResult();
		stockResult.setStocks(stocks);
		return stockResult;
	}

	@Override
	public StockResult find(String textToFind) throws PatologyException {
		// TODO Auto-generated method stub
		return null;
	}

}

