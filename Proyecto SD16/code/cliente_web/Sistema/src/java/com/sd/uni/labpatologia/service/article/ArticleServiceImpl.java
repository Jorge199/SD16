package com.sd.uni.labpatologia.service.article;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.article.ArticleB;
import com.sd.uni.labpatologia.dto.article.ArticleDto;
import com.sd.uni.labpatologia.dto.article.ArticleResult;
import com.sd.uni.labpatologia.rest.article.IArticleResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service("articleService")
public class ArticleServiceImpl extends BaseServiceImpl<ArticleB, ArticleDto> implements IArticleService{
	@Autowired
	private IArticleResource _articleResource;
	
	public ArticleServiceImpl() {
		
	}
	@Override
	public ArticleB save(ArticleB bean) {
		final ArticleDto article = convertBeanToDto(bean);
		final ArticleDto dto = _articleResource.save(article);
		final ArticleB articleB = convertDtoToBean(dto);
		return articleB;
	}

	@Override
	public List<ArticleB> getAll() {
		final ArticleResult result = _articleResource.getAll();
		final List<ArticleDto> articleList = null == result.getArticles() ? new ArrayList<ArticleDto>()
				: result.getArticles();

		final List<ArticleB> laboratories = new ArrayList<ArticleB>();
		for (ArticleDto dto : articleList) {
			final ArticleB bean = convertDtoToBean(dto);
			laboratories.add(bean);
		}
		return laboratories;
	}

	@Override
	public ArticleB getById(Integer id) {
		final ArticleDto dto = _articleResource.getById(id);
		final ArticleB bean = convertDtoToBean(dto);

		return bean;
	}

	@Override
	protected ArticleB convertDtoToBean(ArticleDto dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("units", String.valueOf(dto.getUnits()));		
		params.put("count_stock", String.valueOf(dto.getCount()));
		params.put("name", dto.getName());
		params.put("description", dto.getDescription());
		final ArticleB articleB = new ArticleB(params);
		return articleB;
	}

	@Override
	protected ArticleDto convertBeanToDto(ArticleB bean) {
		final ArticleDto dto = new ArticleDto();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setDescription(bean.getDescription());
		dto.setUnits(bean.getUnits());
		dto.setCount(dto.getCount());
		return dto;
	}
	@Override
	public List<ArticleB> find(String textToFind, int maxItems, int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
