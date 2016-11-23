/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.service.article_movement;

import com.sd.uni.labpatologia.beans.article_movement.ArticleMovementB;
import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementDTO;
import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementResult;
import com.sd.uni.labpatologia.rest.article_movement.ArticleMovementResourceImpl;
import com.sd.uni.labpatologia.rest.article_movement.IArticleMovementResource;
import com.sd.uni.labpatologia.service.article.IArticleService;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("articleMovementService")
public class ArticleMovementServiceImpl extends BaseServiceImpl<ArticleMovementB, ArticleMovementDTO> implements IArticleMovementService{
	@Autowired
	private IArticleMovementResource _articleMovementResource;
        @Autowired
        private IArticleService articleService;
	
	public ArticleMovementServiceImpl() {
		
	}
	@Override
	public ArticleMovementB save(ArticleMovementB bean) {
		final ArticleMovementDTO articleMovement = convertBeanToDto(bean);
		final ArticleMovementDTO dto = _articleMovementResource.save(articleMovement);
		final ArticleMovementB articleMovementB = convertDtoToBean(dto);
		return articleMovementB;
	}

	@Override
	public List<ArticleMovementB> getAll() {
		final ArticleMovementResult result = _articleMovementResource.getAll();
		final List<ArticleMovementDTO> articleList = null == result.getArticleMovements() ? new ArrayList<ArticleMovementDTO>()
				: result.getArticleMovements();
		final List<ArticleMovementB> laboratories = new ArrayList<ArticleMovementB>();
		for (ArticleMovementDTO dto : articleList) {
			final ArticleMovementB bean = convertDtoToBean(dto);
			laboratories.add(bean);
		}
		return laboratories;
	}

	@Override
	public ArticleMovementB getById(Integer id) {
		final ArticleMovementDTO dto = _articleMovementResource.getById(id);
		final ArticleMovementB bean = convertDtoToBean(dto);
		return bean;
	}

	@Override
	protected ArticleMovementB convertDtoToBean(ArticleMovementDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("quantity", String.valueOf(dto.getQuantity()));
		final ArticleMovementB articleMovementB = new ArticleMovementB(params);
                articleMovementB.setArticle(articleService.getById(dto.getArticleId()));
                articleMovementB.setMovementType(dto.getMovtype());
                articleMovementB.setDate(dto.getDate());
		return articleMovementB;
	}

	@Override
	protected ArticleMovementDTO convertBeanToDto(ArticleMovementB bean) {
		final ArticleMovementDTO dto = new ArticleMovementDTO();
		dto.setId(bean.getId());
                dto.setQuantity(bean.getQuantity());
                dto.setArticleId(bean.getArticle().getId());
                dto.setMovtype(bean.getMovementType());
                dto.setDate(bean.getDate());
		return dto;
	}
        
	@Override
	public List<ArticleMovementB> find(String textToFind, int maxItems, int page) {
		final ArticleMovementResult result = _articleMovementResource.find(textToFind, maxItems, page);
		final List<ArticleMovementDTO> rList = null == result.getArticleMovements() ? new ArrayList<ArticleMovementDTO>()
				: result.getArticleMovements();
		final List<ArticleMovementB> articles = new ArrayList<ArticleMovementB>();
		for (ArticleMovementDTO dto : rList) {
			final ArticleMovementB bean = convertDtoToBean(dto);
			articles.add(bean);
		}
		return articles;
	}
}