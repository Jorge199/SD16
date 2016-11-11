/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.beans.stock_mov;

/**
 *
 * @author User
 */
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.article.ArticleB;
import com.sd.uni.labpatologia.beans.base.BaseBean;

public class Stock_movB extends BaseBean {
	private static final long serialVersionUID = 1L;
	private Integer _count;
	private Date _date;
	private Integer _mov_type;
	private ArticleB _article;

	public Stock_movB(Map<String, String> params) {
		super(params);
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setCount(Integer.parseInt(params.get("count")));
		setMovtype(Integer.parseInt(params.get("mov_type")));
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			//setDate(formato.parse(params.get("date")));
			//para que no lance error
			if(null != params.get("date")){
				setDate(formato.parse(params.get("date")));
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
		

		}
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
	
	public void setMovtype(Integer c) {
		_mov_type = c;
	}
	

	
	public ArticleB getArticle() {
		return _article;
	}
	
	public void setArticle(ArticleB ar) {
		_article = ar;
	}
	
	public Date getDate() {
		return _date;
	}
	
	public void setDate(Date d) {
		_date = d;
	}
}
