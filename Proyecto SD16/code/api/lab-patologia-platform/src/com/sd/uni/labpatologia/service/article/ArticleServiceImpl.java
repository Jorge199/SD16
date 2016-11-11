package com.sd.uni.labpatologia.service.article;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.article.IArticleDao;
import com.sd.uni.labpatologia.dao.article.ArticleDaoImpl;
import com.sd.uni.labpatologia.dao.stock_mov.IStockDao;
import com.sd.uni.labpatologia.domain.article.ArticleDomain;
import com.sd.uni.labpatologia.domain.stock_mov.StockDomain;
import com.sd.uni.labpatologia.dto.article.ArticleDto;
import com.sd.uni.labpatologia.dto.article.ArticleResult;
import com.sd.uni.labpatologia.exception.*;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;


@Service
public class ArticleServiceImpl extends BaseServiceImpl<ArticleDto, ArticleDomain, ArticleDaoImpl, ArticleResult> implements IArticleService{
	
	@Autowired
	private IArticleDao _articleDao;

	@Autowired
	private IStockDao _stockDao;
	
	@Override
	@Transactional
	public ArticleDto save(ArticleDto dto) {
		final ArticleDomain ArticleDomain = convertDtoToDomain(dto);
		final ArticleDomain Article = _articleDao.save(ArticleDomain);
		return convertDomainToDto(Article);
	}
	 
	@Override
	@Transactional
	public ArticleDto add_to_stock(Integer id, Integer c) throws PatologyException {
		final ArticleDomain ArticleDomain = _articleDao.getById(id);
		final StockDomain stockDomain = new StockDomain();
		stockDomain.setArticle(ArticleDomain);
		stockDomain.setCount(c);
		stockDomain.setMovtype(StockDomain.INC_VALUE);
		ArticleDomain.setCount((c + ArticleDomain.getCount()));
		final ArticleDomain Article = _articleDao.save(ArticleDomain);
		_stockDao.save(stockDomain);
		return convertDomainToDto(Article);
	}
	
	@Override
	@Transactional
	public ArticleDto remove_from_stock(Integer id, Integer c) throws PatologyException , StockException{
		final ArticleDomain ArticleDomain = _articleDao.getById(id);
		if(c < ArticleDomain.getCount() ){
			ArticleDomain.setCount((ArticleDomain.getCount() - c));			
			final ArticleDomain Article = _articleDao.save(ArticleDomain);
			return convertDomainToDto(Article);		
		} else {
			throw new StockException("Stock insuficiente");
		}
	}	
	
	@Override
	@Transactional
	public ArticleDto getById(Integer id) throws PatologyException {
		final ArticleDomain ArticleDomain = _articleDao.getById(id);
		final ArticleDto ArticleDTO = convertDomainToDto(ArticleDomain);
		return ArticleDTO;
	}

	@Override
	@Transactional
	public ArticleResult getAll() {
		final List<ArticleDto> articles = new ArrayList<>();
		for (ArticleDomain domain : _articleDao.findAll()) {
			final ArticleDto Article = convertDomainToDto(domain);
			articles.add(Article);
		}

		final ArticleResult ArticleResult = new ArticleResult();
		ArticleResult.setArticles(articles);
		return ArticleResult;
	}

	@Override
	protected ArticleDto convertDomainToDto(ArticleDomain domain) {
		final ArticleDto Article = new ArticleDto();
		Article.setId(domain.getId());
		Article.setName(domain.getName());
		Article.setDescription(domain.getDescription());
		Article.setUnits(domain.getUnits());
		Article.setCount(domain.getCount());
		return Article;
	}

	@Override
	protected ArticleDomain convertDtoToDomain(ArticleDto dto) {
		final ArticleDomain Article = new ArticleDomain();
		Article.setId(dto.getId());
		Article.setName(dto.getName());
		Article.setDescription(dto.getDescription());
		Article.setUnits(dto.getUnits());
		Article.setCount(dto.getCount());
		return Article;
	}

	@Override
	@Transactional
	public ArticleResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<ArticleDto> articles = new ArrayList<>();
		for (ArticleDomain domain : _articleDao.find(textToFind, page, maxItems)) {
			final ArticleDto dto = convertDomainToDto(domain);
			articles.add(dto);
		}
		final ArticleResult ArticleResult = new ArticleResult();
		ArticleResult.setArticles(articles);
		return ArticleResult;
	}

	

}
