package com.sd.uni.labpatologia.rest.article;

import com.sd.uni.labpatologia.dto.article.ArticleDto;
import com.sd.uni.labpatologia.dto.article.ArticleResult;
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@Repository("articleResource")
public class ArticleResourceImpl extends BaseResourceImpl<ArticleDto> implements
		IArticleResource {

	public ArticleResourceImpl() {
		super(ArticleDto.class, "/article");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'articles'")
	@CachePut(value = CACHE_REGION, key = "'article_' + #article.id", condition = "#article.id!=null")
	public ArticleDto save(ArticleDto article) {
		ArticleDto newDto = super.save(article);
		if (null == article.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"article_" + newDto.getId(), newDto);
		}
		return newDto;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'article_' + #id")
	public ArticleDto getById(Integer id) {
		return super.getById(id);
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'articles'")
	public ArticleResult getAll() {
		setWebResourceBasicAuthFilter();
		final ArticleResult result = getWebResource().get(ArticleResult.class);
		return result;
	}

	public int getCount(){
		setWebResourceBasicAuthFilter();
		final ArticleResult countResult = getCountResult().get(ArticleResult.class);
		return countResult.getCount();
	}
	
    @Override
    public ArticleResult find(String textToFind, int maxItems, int page) {
        setWebResourceBasicAuthFilter();
		final ArticleResult result = findWR(textToFind, maxItems, page).get(
				ArticleResult.class);
		return result;
    }
}
