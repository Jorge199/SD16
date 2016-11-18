package com.sd.uni.labpatologia.dto.article_movement;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;

@XmlRootElement(name = "articleMovementResult")
public class ArticleMovementResult extends BaseResult<ArticleMovementDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ArticleMovementDTO> getArticleMovements() {
		return getList();
	}

	public void setArticleMovements(List<ArticleMovementDTO> dtos) {
		super.setList(dtos);
	}
}