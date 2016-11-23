/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.beans.article_movement;

/**
 *
 * @author User
 */
import com.sd.uni.labpatologia.beans.article.ArticleB;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;
import com.sd.uni.labpatologia.util.MovementTypeEnum;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticleMovementB extends BaseBean {

    private static final long serialVersionUID = 1L;
    private ArticleB _article;
    private Integer _quantity;
    private MovementTypeEnum _movementType;
    private Date _date;

    public ArticleMovementB(Map<String, String> params) {
        super(params);
    }

    @Override
    protected void create(Map<String, String> params) {
        if (!StringUtils.isBlank(params.get("id"))) {
            setId(Integer.valueOf(params.get("id")));
        }
        if (!StringUtils.isBlank(params.get("movementType"))) {
            setMovementType(Enum.valueOf(MovementTypeEnum.class, params.get("movementType")));
        }
        if (!StringUtils.isBlank(params.get("quantity"))) {
            setQuantity(Integer.parseInt(params.get("quantity")));
        }
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        if(null != params.get("date")){
            try {
                setDate(formato.parse(params.get("date")));
            } catch (ParseException ex) {
                Logger.getLogger(ArticleMovementB.class.getName()).log(Level.SEVERE, null, ex);
            }
	}
    }
    
    public ArticleB getArticle(){
        return _article;
    }

    public void setArticle(ArticleB article) {
        this._article = article;
    }

    public Integer getQuantity() {
        return _quantity;
    }

    public void setQuantity(Integer quantity) {
        this._quantity = quantity;
    }

    public MovementTypeEnum getMovementType() {
        return _movementType;
    }

    public void setMovementType(MovementTypeEnum movementType) {
        this._movementType = movementType;
    }

    public Date getDate() {
        return _date;
    }

    public void setDate(Date date) {
        this._date = date;
    }
}
