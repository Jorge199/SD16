package com.sd.uni.labpatologia.dao.article_movement;

import java.util.List;

import com.sd.uni.labpatologia.dao.base.IBaseDao;
import com.sd.uni.labpatologia.domain.article_movement.ArticleMovementDomain;
import com.sd.uni.labpatologia.exception.PatologyException;


public interface IArticleMovementDao extends IBaseDao<ArticleMovementDomain>{
	public List<ArticleMovementDomain> find(String textToFind) throws PatologyException;
}
