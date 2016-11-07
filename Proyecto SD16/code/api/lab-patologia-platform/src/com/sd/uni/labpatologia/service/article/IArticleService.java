package com.sd.uni.labpatologia.service.article;

import com.sd.uni.labpatologia.dao.article.ArticleDaoImpl;
import com.sd.uni.labpatologia.domain.article.ArticleDomain;
import com.sd.uni.labpatologia.dto.article.ArticleDto;
import com.sd.uni.labpatologia.dto.article.ArticleResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.exception.StockException;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IArticleService extends IBaseService<ArticleDto, ArticleDomain, ArticleDaoImpl, ArticleResult>{

	ArticleDto add_to_stock(Integer c, Integer c2) throws PatologyException;

	ArticleDto remove_from_stock(Integer id, Integer c)
			throws PatologyException, StockException;
	
}
