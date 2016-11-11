package sistema

import com.sd.uni.labpatologia.beans.article.ArticleB
import com.sd.uni.labpatologia.service.article.IArticleService
import com.sd.uni.labpatologia.service.stock_mov.IStockService

class StockController {
	
	static allowedMethods = [save: "POST", 	 delete: "POST"]
	//services
	def IArticleService articleService
	def IStockService stockService
	
	def index() {
		redirect(action: "listar", params: params)
	}

	def add(){
		def stockIn = stockService.getAll()
		render(view: "stock_mov", model: [stockInstanceList: stockIn, stockInstanceTotal: stockIn?.size() , view_opc:"add"])
	}
	
	def remove(){
		def stockIn = stockService.getAll()
		render(view: "stock_mov", model: [stockInstanceList: stockIn, stockInstanceTotal: stockIn?.size() , view_opc:"rm"])
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

	def edit(Long id){
		def articleInstance = articleService.getById(id.intValue())
		if (!articleInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'article.label', default: 'Article'),
				id
			])
			redirect(action: "listar")
			return
		}

		[articleInstance: articleInstance]
	}
}
