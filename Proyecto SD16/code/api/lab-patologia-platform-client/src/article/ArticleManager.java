package article;

import com.sd.uni.labpatologia.dto.article.ArticleDto;

import base.AbstractBaseManager;

public class ArticleManager extends AbstractBaseManager{
	public ArticleManager() {
		super();
	}

	public void addArticle(String name, String description, String units) {
		ArticleDto article = new ArticleDto();
		article.setName(name);
		article.setDescription(description);
		//article.setQuantity(0);
		article.setUnits(units);
		getJerseyClient().resource(getBaseUrl() + "/article").entity(article).post(ArticleDto.class);

	}
}
