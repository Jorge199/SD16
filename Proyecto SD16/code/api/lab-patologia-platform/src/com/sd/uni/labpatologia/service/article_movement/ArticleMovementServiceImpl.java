package com.sd.uni.labpatologia.service.article_movement;

import java.util.ArrayList;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.article.IArticleDao;
import com.sd.uni.labpatologia.dao.article_movement.ArticleMovementDaoImpl;
import com.sd.uni.labpatologia.dao.article_movement.IArticleMovementDao;
import com.sd.uni.labpatologia.domain.article.ArticleDomain;
import com.sd.uni.labpatologia.domain.article_movement.ArticleMovementDomain;
import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementDTO;
import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.exception.StockException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import com.sd.uni.labpatologia.service.request.RequestServiceImpl;
import com.sd.uni.labpatologia.util.MovementTypeEnum;

@Service
public class ArticleMovementServiceImpl extends BaseServiceImpl<ArticleMovementDTO, ArticleMovementDomain, ArticleMovementDaoImpl, ArticleMovementResult>
		implements IArticleMovementService {
	@Autowired
	private IArticleMovementDao articleMovementDao;

	@Autowired
	private IArticleDao articleDao;
	
	private static Logger logger = Logger.getLogger(ArticleMovementServiceImpl.class);

	@Override
	@Transactional

	//@CacheEvict(value = "lab-patologia-platform-cache", key = "'stocks'")
	@CachePut(value = "lab-patologia-platform-cache", key = "'stock_' + #dto.id", condition = "#dto.id!=null")
	public ArticleMovementDTO save(ArticleMovementDTO dto) {
		try {
			if(dto.getMovtype().equals(MovementTypeEnum.SALIDA)){
				ArticleDomain article = articleDao.getById(dto.getArticleId());
				if(dto.getQuantity() > article.getQuantity()){
					throw new PatologyException("Stock insuficiente");
				}
				article.setQuantity(article.getQuantity() - dto.getQuantity());
				articleDao.save(article);
			}else{
				ArticleDomain article = articleDao.getById(dto.getArticleId());
				article.setQuantity(article.getQuantity() + dto.getQuantity());
				articleDao.save(article);
			}
		} catch (PatologyException ex) {
			logger.error(ex);
			throw new RuntimeException("Error "+ArticleMovementServiceImpl.class+" " + ex.getMessage(), ex); 
		}
		final ArticleMovementDomain domain = convertDtoToDomain(dto);
		final ArticleMovementDomain movement = articleMovementDao.save(domain);
		ArticleMovementDTO newDto = convertDomainToDto(movement);
		if (dto.getId() == null) {
			getCacheManager().getCache("lab-patologia-platform-cache").put("stock_" + movement.getId(), newDto);
		}
		return newDto;
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "lab-patologia-platform-cache", key = "'stock_' + #id")
	public ArticleMovementDTO getById(Integer id) throws PatologyException {
		final ArticleMovementDomain domain = articleMovementDao.getById(id);
		final ArticleMovementDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	//@Cacheable(value = "lab-patologia-platform-cache", key = "'stocks'")
	public ArticleMovementResult getAll() {
		final List<ArticleMovementDTO> movements = new ArrayList<>();
		for (ArticleMovementDomain domain : articleMovementDao.findAll()) {
			final ArticleMovementDTO dto = convertDomainToDto(domain);
			movements.add(dto);
		}
		final ArticleMovementResult articleMovementResult = new ArticleMovementResult();
		articleMovementResult.setArticleMovements(movements);
		return articleMovementResult;
	}

	@Override
	protected ArticleMovementDTO convertDomainToDto(ArticleMovementDomain domain) {
		final ArticleMovementDTO dto = new ArticleMovementDTO();
		dto.setId(domain.getId());
		if (null != domain.getArticle())
			dto.setArticleId(domain.getArticle().getId());
		if (null != domain.getQuantity())
			dto.setQuantity(domain.getQuantity());
		if (null != domain.getMovtype())
			dto.setMovtype(domain.getMovtype());
		if (null != domain.getDate())
			dto.setDate(domain.getDate());
		return dto;
	}

	@Override
	protected ArticleMovementDomain convertDtoToDomain(ArticleMovementDTO dto) {
		final ArticleMovementDomain domain = new ArticleMovementDomain();
		domain.setId(dto.getId());
		try {
			if (null != dto.getArticleId())
				domain.setArticle(articleDao.getById(dto.getArticleId()));
		} catch (PatologyException e) {
			e.printStackTrace();
		}
		if (null != dto.getQuantity())
			domain.setQuantity(dto.getQuantity());
		if (null != dto.getMovtype())
			domain.setMovtype(dto.getMovtype());
		if (null != dto.getDate())
			domain.setDate(dto.getDate());

		return domain;
	}

	@Override
	@Transactional(readOnly = true)
	public ArticleMovementResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<ArticleMovementDTO> stocks = new ArrayList<>();
		for (ArticleMovementDomain domain : articleMovementDao.find(textToFind, page, maxItems)) {
			final ArticleMovementDTO dto = convertDomainToDto(domain);
			stocks.add(dto);
		}
		final ArticleMovementResult stockResult = new ArticleMovementResult();
		stockResult.setArticleMovements(stocks);
		return stockResult;
	}
	
	@Override
	@Transactional(readOnly = true)
	public ArticleMovementResult find(String textToFind) throws PatologyException {
		final List<ArticleMovementDTO> stocks = new ArrayList<>();
		for (ArticleMovementDomain domain : articleMovementDao.find(textToFind)) {
			final ArticleMovementDTO dto = convertDomainToDto(domain);
			stocks.add(dto);
		}
		final ArticleMovementResult stockResult = new ArticleMovementResult();
		stockResult.setArticleMovements(stocks);
		return stockResult;
	}

}
