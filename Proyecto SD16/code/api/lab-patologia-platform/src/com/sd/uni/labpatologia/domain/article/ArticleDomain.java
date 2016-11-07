package com.sd.uni.labpatologia.domain.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;

@Entity
@Table(name = "article")
public class ArticleDomain extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "name")
	private String _name;

	@Column(name = "description")
	private String _description;

	
	@Column(name = "units")
	private Integer _units;
	
	@Column(name = "count_stock")
	private Integer _count_stock;
	
	
	public Integer getId() {
		return _id;
	}
	
	public void setId(Integer id) {
		_id = id;
	}
	
	public Integer getUnits() {
		return _units;
	}

	public void setUnits(Integer _uits) {
		_units = _uits;
	}
	
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		_name = name;
	}
	
	public String getDescription() {
		return _description;
	}
	public void setDescription(String des) {
		_description = des;
	}
	public Integer getCount() {
		return _count_stock;
	}

	public void setCount(Integer c) {
		_count_stock = c;
	}	
}