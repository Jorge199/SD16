package com.sd.uni.labpatologia.domain.article_movement;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.util.MovementTypeEnum;
import com.sd.uni.labpatologia.domain.article.ArticleDomain;

@Entity
@Table(name = "article_movement")
public class ArticleMovementDomain extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@ManyToOne
	private ArticleDomain _article;
	
	@Column(name = "quantity")
	private Integer _quantity;

	@Enumerated(EnumType.STRING)
	private MovementTypeEnum _movement_type;
	
	@Column(name = "date")
	private Date _date;
	
	public Integer getId() {
		return _id;
	}
	
	public void setId(Integer id) {
		_id = id;
	}
	
	public ArticleDomain getArticle() {
		return _article;
	}
	
	public void setArticle(ArticleDomain ad) {
		_article = ad;
	}
	
	public Integer getQuantity() {
		return _quantity;
	}

	public void setQuantity(Integer c) {
		_quantity = c;
	}
	
	public MovementTypeEnum getMovtype() {
		return _movement_type;
	}
	public void setMovtype(MovementTypeEnum movementType) {
		_movement_type = movementType;
	}
	
	public Date getDate() {
		return _date;
	}
	
	public void setDate(Date dat) {
		_date = dat;
	}
}
