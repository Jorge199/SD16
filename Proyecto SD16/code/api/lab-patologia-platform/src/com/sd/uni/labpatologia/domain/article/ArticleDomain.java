package com.sd.uni.labpatologia.domain.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Value;

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
	private String _units;
	
	@Column(name = "quantity")
	private Integer _quantity;
	
	
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
	
	public String getDescription() {
		return _description;
	}
	
	public void setDescription(String des) {
		_description = des;
	}
	
	public Integer getQuantity() {
		return _quantity;
	}

	public void setQuantity(Integer c) {
		_quantity = c;
	}
}