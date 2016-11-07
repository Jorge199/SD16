package com.sd.uni.labpatologia.dto.article;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "article")
public class ArticleDto extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _description;
	private String _units;
	private Integer _count_stock;
	
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
	public String getDescription() {
		return _description;
	}
	
	public void setDescription(String des) {
		_description = des;
	}
	
	@XmlElement
	public Integer getCount() {
		return _count_stock;
	}

	public void setCount(Integer c) {
		_count_stock = c;
	}	
}
