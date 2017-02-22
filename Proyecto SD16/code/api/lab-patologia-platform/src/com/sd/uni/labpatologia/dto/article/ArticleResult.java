package com.sd.uni.labpatologia.dto.article;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;

@XmlRootElement(name = "ArticleResult")
public class ArticleResult extends BaseResult<ArticleDto>{
	private static final long serialVersionUID = 1L;
	private int _count;

	@XmlElement
	public List<ArticleDto> getArticles() {
		return getList();
	}

	public void setArticles(List<ArticleDto> dtos) {
		super.setList(dtos);
	}

	public int getCount(){
		return _count;
	}
	public void setCount(int count){
		_count = count;
	}
}
