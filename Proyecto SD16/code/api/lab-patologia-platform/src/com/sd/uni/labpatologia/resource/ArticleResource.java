package com.sd.uni.labpatologia.resource;


import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.article.ArticleDto;
import com.sd.uni.labpatologia.dto.article.ArticleResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.exception.StockException;
import com.sd.uni.labpatologia.service.article.IArticleService;


@Path("/article")
@Component
public class ArticleResource {

	@Autowired
	private IArticleService _articleService;
	
	/* http://localhost:8080/lab-patologia-platform/rest/article/1 */
	@GET
	@Path("/{id}")
	@Produces("application/json")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_TECNICO"})
	public ArticleDto getById(@PathParam("id") Integer articleId) throws PatologyException {
		return _articleService.getById(articleId);
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/article */
	@GET
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_SECRETARIA","ROLE_TECNICO"})
	public ArticleResult getAll() throws PatologyException {
		return _articleService.getAll();
	}
	
	/* http://localhost:8080/lab-patologia-platform/rest/article/search/textToFind */
	@GET
	@Path("/search/{max}/{page}/{textToFind}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_TECNICO"})
	public ArticleResult search(@PathParam("textToFind") String textToFind, @PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _articleService.find(textToFind, page, maxItems);
	}
	
	@GET
	@Path("/search/{max}/{page}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_TECNICO"})
	public ArticleResult search(@PathParam("page") Integer page, @PathParam("max") Integer maxItems) throws PatologyException {
		return _articleService.find(null, page, maxItems);
	}

	
	/* http://localhost:8080/lab-patologia-platform/rest/article/add/{id}/{c} */
	@GET
	@Path("/add/{id}/{c}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_TECNICO"})
	public ArticleDto add_to_stock(@PathParam("id") Integer id,@PathParam("c") Integer c) throws PatologyException {

		return _articleService.add_to_stock(id,c);
	}

	/* http://localhost:8080/lab-patologia-platform/rest/article/remove/{id}/{c} */
	@GET
	@Path("/remove/{id}/{c}")
	@Produces("application/xml")
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_TECNICO"})
	public ArticleDto remove_to_stock(@PathParam("id") Integer id,@PathParam("c") Integer c) throws PatologyException, StockException {
		return _articleService.remove_from_stock(id,c);
	}
	
	@POST
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR","ROLE_TECNICO"})
	public ArticleDto save(ArticleDto art) {
		return _articleService.save(art);
	}

}
