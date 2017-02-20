package com.sd.uni.labpatologia.dto.article;

import javax.xml.bind.annotation.XmlRootElement;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;

//import com.sd.uni.labpatologia.domain.article_lot.ArticleLotDomain;
import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "article")
public class ArticleDto extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _description;
	private String _units;
	private Integer _quantity;
	
	@XmlElement
	public String getUnits() {
		return _units;
	}

	public void setUnits(String units) {
		_units = units;
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
	
	public void setDescription(String description) {
		_description = description;
	}
	
	@XmlElement
	public Integer getQuantity() {
		return _quantity;
	}

	public void setQuantity(Integer count) {
		_quantity = count;
	}
}
