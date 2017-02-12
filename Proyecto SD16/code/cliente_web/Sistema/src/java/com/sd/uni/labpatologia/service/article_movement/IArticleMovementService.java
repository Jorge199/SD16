/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.service.article_movement;

import com.sd.uni.labpatologia.beans.article_movement.ArticleMovementB;
import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementDTO;
import com.sd.uni.labpatologia.service.base.IBaseService;
import java.util.List;

/**
 *
 * @author Alex Jiñes
 */
public interface IArticleMovementService extends IBaseService<ArticleMovementB, ArticleMovementDTO>{
    public List<ArticleMovementB> find(String textToFind);
}
