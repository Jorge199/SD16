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
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;

public class ArticleB extends BaseBean {
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _description;
	private Integer _quantity;
	private String _units;

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
                if(null != params.get("quantity")){
                    setQuantity(Integer.parseInt(params.get("quantity")));
                }
                setUnits(params.get("units"));        
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
	public void setQuantity(Integer cs) {
		_quantity = cs;
	}
	public String getUnits() {
		return _units;
	}
	public void setUnits(String unit) {
		_units = unit;
	}
	
}
