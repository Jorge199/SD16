package com.sd.uni.labpatologia.rest.article;

import com.sd.uni.labpatologia.dto.article.ArticleDto;
import com.sd.uni.labpatologia.dto.article.ArticleResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

public interface IArticleResource extends IBaseResource<ArticleDto> {
	public ArticleResult getAll();
        public ArticleResult find(String textToFind, int maxItems, int page);
}
