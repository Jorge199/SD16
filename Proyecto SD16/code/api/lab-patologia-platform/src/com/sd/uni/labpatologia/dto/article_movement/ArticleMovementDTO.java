package com.sd.uni.labpatologia.dto.article_movement;


import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.util.MovementTypeEnum;
import com.sd.uni.labpatologia.util.StatusEnum;

@XmlRootElement(name = "articleMovement")
public class ArticleMovementDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _articleId;
	private Integer _count;
	private MovementTypeEnum _mov_type;
	private Date _date;
	
	@XmlElement
	public Integer getArticleId() {
		return _articleId;
	}

	public void setArticleId(Integer aId) {
		_articleId = aId;
	}

	@XmlElement
	public Integer getQuantity() {
		return _count;
	}

	public void setQuantity(Integer count) {
		_count = count;
	}
	
	@XmlElement
	public MovementTypeEnum getMovtype() {
		return _mov_type;
	}

	public void setMovtype(MovementTypeEnum mov) {
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
