package com.sd.uni.labpatologia.service.article_movement;

import com.sd.uni.labpatologia.dao.article_movement.ArticleMovementDaoImpl;
import com.sd.uni.labpatologia.domain.article_movement.ArticleMovementDomain;
import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementDTO;
import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IArticleMovementService extends IBaseService<ArticleMovementDTO, ArticleMovementDomain, ArticleMovementDaoImpl, ArticleMovementResult> {
	
}