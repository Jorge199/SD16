package com.sd.uni.labpatologia.rest.article;

import com.sd.uni.labpatologia.dto.article.ArticleDto;
import com.sd.uni.labpatologia.dto.article.ArticleResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("articleResource")
public class ArticleResourceImpl extends BaseResourceImpl<ArticleDto> implements IArticleResource{
	public ArticleResourceImpl(){
		super(ArticleDto.class,"/article");
	}
	
	@Override
	@CacheEvict(value = CACHE_REGION, key = "'article_' + #dto.id", condition = "#dto.id!=null")
	public ArticleDto save(ArticleDto dto) {
		final ArticleDto article = getWebResource().entity(dto).post(getDtoClass());
		return article;
	}

	@Cacheable(value = CACHE_REGION, key = "'article_' + #id")
	@Override
	public ArticleDto getById(Integer id) {
		return super.getById(id);
	}
	
	@Cacheable(value = CACHE_REGION, key = "'articles'")
	@Override
	public ArticleResult getAll() {
		final ArticleResult result = getWebResource().get(ArticleResult.class);
		return result;
	}
}
