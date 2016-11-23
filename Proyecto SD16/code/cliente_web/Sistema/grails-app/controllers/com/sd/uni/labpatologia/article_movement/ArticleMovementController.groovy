package com.sd.uni.labpatologia.article_movement

import com.sd.uni.labpatologia.beans.article_movement.ArticleMovementB
import com.sd.uni.labpatologia.service.article.IArticleService
import com.sd.uni.labpatologia.service.article_movement.ArticleMovementServiceImpl
import com.sd.uni.labpatologia.service.article_movement.IArticleMovementService
import com.sd.uni.labpatologia.service.auth.IAuthService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.util.MovementTypeEnum
import grails.plugin.springsecurity.annotation.Secured;
import java.util.Calendar;
import java.text.SimpleDateFormat
import org.springframework.beans.factory.annotation.Autowired

class ArticleMovementController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	//services
        def IArticleMovementService articleMovementService
        def ILaboratoryService laboratoryService
        def IArticleService articleService
	@Autowired def IAuthService authService

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def index() {
		redirect(action: "list", params: params)
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def create(){
		[articleMovementInstance: new ArticleMovementB(params), articles: articleService.getAll(), laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def list(Integer max) {
		def page = 0
		def siguiente
		if(null != params.get("page")){
			page = Integer.parseInt(params.get("page"))
		}
		def text = params.text
		def articleMovements = null
		if(null != text && !"".equals(text)){
			articleMovements = articleMovementService.find(text,10,page)
			siguiente = articleMovementService.find(text,10,page+1)
		}else{
			articleMovements = articleMovementService.find(null,10,page)
			siguiente = articleMovementService.find(null,10,page+1)
		}
		[articleMovementInstanceList: articleMovements, articles: articleService.getAll(), articleMovementInstanceTotal: articleMovements?.size(), page: page, siguiente: siguiente?.size(), text: text, laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def save() {
		def articleMovementInstance = new ArticleMovementB(params)
		articleMovementInstance.setDate(Calendar.getInstance().getTime());
                articleMovementInstance.setArticle(articleService.getById(Integer.parseInt(params.get("articleId"))))
                articleMovementInstance.setMovementType(MovementTypeEnum.valueOf(params.get("movementType")))
		def newMovementArticle = articleMovementService.save(articleMovementInstance)
		flash.message = message(code: 'default.created.message', args: [
			message(code: 'articleMovement.label', default: 'ArticleMovement'),
			newMovementArticle.getId()
		])
		redirect(action: "list")
	}

	/*@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def edit(Long id) {
		def articleMovementInstance = articleMovementService.getById((Integer.parseInt(params.get("id"))))

		[articleInstance: articleMovementInstance,laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def update(Long id) {
		def articleMovementInstance = articleMovementService.getById(Integer.parseInt(params.get("edit")))
		System.out.println(articleMovementInstance.getId())
		articleMovementInstance.setName(params.get("name"))
		articleMovementInstance.setDescription(params.get("description"))
		articleMovementInstance.setUnits(params.get("units"))
		articleMovementService.save(articleMovementInstance)
		redirect(action: "list")
	}*/

}

