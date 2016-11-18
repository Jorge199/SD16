package article_movement;

import java.util.Date;

import com.sd.uni.labpatologia.dto.article_movement.ArticleMovementDTO;
import com.sd.uni.labpatologia.util.MovementTypeEnum;

import base.AbstractBaseManager;

public class ArticleMovementManager extends AbstractBaseManager{
	public ArticleMovementManager() {
		super();
	}

	public void addArticle(int articleId, Date date, MovementTypeEnum movType, int quantity) {
		ArticleMovementDTO articleMovement = new ArticleMovementDTO();
		articleMovement.setArticleId(articleId);
		articleMovement.setDate(date);
		articleMovement.setMovtype(movType);
		articleMovement.setQuantity(quantity);
		getJerseyClient().resource(getBaseUrl() + "/article_movement").entity(articleMovement).post(ArticleMovementDTO.class);
	}
}
