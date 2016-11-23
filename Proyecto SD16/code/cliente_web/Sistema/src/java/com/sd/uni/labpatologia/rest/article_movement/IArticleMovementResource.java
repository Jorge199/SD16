package com.sd.uni.labpatologia.rest.article_movement;

import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementDTO;
import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

/**
 *
 * @author Alex Jiñes
 */
public interface IArticleMovementResource extends IBaseResource<ArticleMovementDTO> {
	public ArticleMovementResult getAll();
        public ArticleMovementResult find(String textToFind, int maxItems, int page);
}

