package com.sd.uni.labpatologia.dto.article;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;
import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.dto.article.ArticleDto;

import java.util.List;

@XmlRootElement(name = "ArticleResult")
public class ArticleResult extends BaseResult<ArticleDto>{
	private static final long serialVersionUID = 1L;
	
	@XmlElement
	public List<ArticleDto> getArticles() {
		return getList();
	}

	public void setArticles(List<ArticleDto> dtos) {
		super.setList(dtos);
	}

}
