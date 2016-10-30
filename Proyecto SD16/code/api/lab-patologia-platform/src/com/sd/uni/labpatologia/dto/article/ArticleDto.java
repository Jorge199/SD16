package com.sd.uni.labpatologia.dto.article;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "article")
public class ArticleDto extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _units;
	private Integer _count;
	
	@XmlElement
	public String getUnits() {
		return _units;
	}

	public void setUnits(String uni) {
		_units = uni;
	}
	
	@XmlElement
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	@XmlElement
	public Integer getCount() {
		return _count;
	}

	public void setCount(Integer c) {
		_count = c;
	}	
}
