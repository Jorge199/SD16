package com.sd.uni.labpatologia.rest.article_movement;

import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementDTO;
import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alex Jiñes
 */
@Repository("articleMovementResource")
public class ArticleMovementResourceImpl extends BaseResourceImpl<ArticleMovementDTO> implements
        IArticleMovementResource {

    public ArticleMovementResourceImpl() {
        super(ArticleMovementDTO.class, "/article_movement");
    }

    @Override
    //@CacheEvict(value = CACHE_REGION, key = "'articleMovements'")
    @CachePut(value = CACHE_REGION, key = "'articleMovement_' + #articleMovement.id", condition = "#articleMovement.id!=null")
    public ArticleMovementDTO save(ArticleMovementDTO articleMovement) {
    	ArticleMovementDTO newDto = super.save(articleMovement);
        if (null == articleMovement.getId()) {
            getCacheManager().getCache(CACHE_REGION).put(
                    "articleMovement_" + newDto.getId(), newDto);
        }
        return newDto;
    }

    @Override
    @Cacheable(value = CACHE_REGION, key = "'articleMovement_' + #id")
    public ArticleMovementDTO getById(Integer id) {
        return super.getById(id);
    }

    @Override
    //@Cacheable(value = CACHE_REGION, key = "'articleMovements'")
    public ArticleMovementResult getAll() {
        setWebResourceBasicAuthFilter();
        final ArticleMovementResult result = getWebResource().get(ArticleMovementResult.class);
        return result;
    }

    @Override
    public ArticleMovementResult find(String textToFind, int maxItems, int page) {
        setWebResourceBasicAuthFilter();
        final ArticleMovementResult result = findWR(textToFind, maxItems, page).get(
                ArticleMovementResult.class);
        return result;
    }
}
