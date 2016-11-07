package com.sd.uni.labpatologia.rest.article;

import com.sd.uni.labpatologia.dto.article.ArticleDto;

import com.sd.uni.labpatologia.dto.article.ArticleResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;
import org.springframework.stereotype.Repository;

@Repository("articleResource")
public class ArticleResourceImpl extends BaseResourceImpl<ArticleDto> implements IArticleResource{
	public ArticleResourceImpl(){
		super(ArticleDto.class,"/article");
	}

	@Override
	public ArticleResult getAll() {
		final ArticleResult result = getWebResource().get(ArticleResult.class);
		return result;
	}
}
