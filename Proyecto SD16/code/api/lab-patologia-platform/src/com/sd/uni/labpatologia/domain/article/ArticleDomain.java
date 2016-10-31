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
	
	@Column(name = "units")
	private String _units;
	
	@Column(name = "count")
	private Integer _count;
	
	
	public Integer getId() {
		return _id;
	}
	public void setId(Integer id) {
		_id = id;
	}
	
	public String getUnits() {
		return _units;
	}

	public void setUnits(String _uits) {
		_units = _uits;
	}
	
	public String getName() {
		return _name;
	}
	public void setName(String name) {
		_name = name;
	}

	public Integer getCount() {
		return _count;
	}

	public void setCount(Integer c) {
		_count = c;
	}	
}