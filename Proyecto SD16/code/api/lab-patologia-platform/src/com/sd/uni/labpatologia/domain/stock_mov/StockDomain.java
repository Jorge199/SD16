package com.sd.uni.labpatologia.domain.stock_mov;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.domain.article.ArticleDomain;

@Entity
@Table(name = "stock_mov")
public class StockDomain extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@ManyToOne
	private ArticleDomain _article;
	
	@Column(name = "count")
	private Integer _count;

	@Column(name = "mov_type")
	private Integer _mov_type;
	
	@Column(name = "date")
	private Date _date;
	
	public static Integer INC_VALUE = 1;
	
	public static Integer DEC_VALUE = 0;
	
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
	
	public Integer getCount() {
		return _count;
	}

	public void setCount(Integer c) {
		_count = c;
	}
	
	public Integer getMovtype() {
		return _mov_type;
	}
	public void setMovtype(Integer mt) {
		_mov_type = mt;
	}
	
	public Date getDate() {
		return _date;
	}
	
	public void setDate(Date dat) {
		_date = dat;
	}
}
