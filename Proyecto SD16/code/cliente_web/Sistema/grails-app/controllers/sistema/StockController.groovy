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
	
	def listar(Integer max){
		def articles = articleService.getAll()
		[articleInstanceList: articles, articleInstanceTotal: articles?.size()]
	}

	def edit(){
	
	}
}
