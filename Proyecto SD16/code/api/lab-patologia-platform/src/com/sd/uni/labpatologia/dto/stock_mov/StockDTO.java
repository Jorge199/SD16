package com.sd.uni.labpatologia.dto.stock_mov;


import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.util.StatusEnum;

@XmlRootElement(name = "stock")
public class StockDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _articleId;
	private Integer _count;
	private Integer _mov_type;
	private Date _date;
	
	@XmlElement
	public Integer getArticleId() {
		return _articleId;
	}

	public void setArticleId(Integer aId) {
		_articleId = aId;
	}

	
	@XmlElement
	public Integer getCount() {
		return _count;
	}

	public void setCount(Integer count) {
		_count = count;
	}
	
	@XmlElement
	public Integer getMovtype() {
		return _mov_type;
	}

	public void setMovtype(Integer mov) {
		_mov_type = mov;
	}
	
	@XmlElement
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}
	
}
