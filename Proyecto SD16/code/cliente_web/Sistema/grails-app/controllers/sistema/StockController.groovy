package sistema

import com.sd.uni.labpatologia.beans.article.ArticleB
import com.sd.uni.labpatologia.service.article.IArticleService

class StockController {
	
	static allowedMethods = [save: "POST", 	 delete: "POST"]
	//services
	def IArticleService articleService
	
	def index() {
		redirect(action: "listar", params: params)
	}

	def add(){
		def articles = articleService.getAll()
		render(view: "stock_mov", model: [articleInstanceList: articles, articleInstanceTotal: articles?.size() , view_opc:"add"])	
	}
	
	def remove(){
		def articles = articleService.getAll()
		render(view: "stock_mov", model: [articleInstanceList: articles, articleInstanceTotal: articles?.size()])
	}
	
	def crear_articulo(){

	}

	def save(){
		def articleInstance = new ArticleB(params)		
		System.out.println(articleInstance.getName() + " , "  + articleInstance.getCount_stock()+ " , " + articleInstance.getDescription() + ", " + articleInstance.getUnits());
		def newArticle= articleService.save(articleInstance)
		if (!newArticle?.getId()) {
			render(view: "crear_articulo", model: [articleInstance: articleInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'article.label', default: 'Article'),
			newArticle.getId()
		])
		redirect(action: "listar", id: newArticle.getId())
	}	
	
	
	def listar(Integer max){
		def articles = articleService.getAll()
		[articleInstanceList: articles, articleInstanceTotal: articles?.size()]
	}

	def edit(){
	
	}
}
