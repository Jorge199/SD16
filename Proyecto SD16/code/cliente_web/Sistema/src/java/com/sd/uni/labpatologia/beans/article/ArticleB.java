/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.beans.article;

/**
 *
 * @author User
 */
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;

public class ArticleB extends BaseBean {
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _description;
	private Integer _count_stock;
	private Integer _units;
	//private RequestB _request;

	public ArticleB(Map<String, String> params) {
		super(params);
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
		setDescription(params.get("description"));	
        setCount_stock(Integer.parseInt(params.get("count_stock")));
        setUnits(Integer.parseInt(params.get("units")));        
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
	
	public Integer getCount_stock() {
		return _count_stock;
	}
	public void setCount_stock(Integer cs) {
		_count_stock = cs;
	}
	public Integer getUnits() {
		return _units;
	}
	public void setUnits(Integer unit) {
		_units = unit;
	}
	
}
