package com.sd.uni.labpatologia.article

import grails.plugin.springsecurity.annotation.Secured;
import grails.converters.JSON

import com.sd.uni.labpatologia.beans.article.ArticleB
import com.sd.uni.labpatologia.beans.doctor.DoctorB
import com.sd.uni.labpatologia.service.article.ArticleServiceImpl
import com.sd.uni.labpatologia.service.article.IArticleService
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.beans.factory.annotation.Autowired;


class ArticleController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	//services
	def IArticleService articleService = new ArticleServiceImpl()
	def ILaboratoryService laboratoryService
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
		[articleInstance: new ArticleB(params),laboratoryInstanceList: laboratoryService.getAll(),
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
		def articles = null
		if(null != text && !"".equals(text)){
			articles = articleService.find(text,10,page)
			siguiente = articleService.find(text,10,page+1)
		}else{
			articles = articleService.find(null,10,page)
			siguiente = articleService.find(null,10,page+1)
		}
		[articleInstanceList: articles, articleInstanceTotal: articles?.size(), page: page, siguiente: siguiente?.size(), text: text, laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def save() {
		def articleInstance = new ArticleB(params)
		def newArticle = articleService.save(articleInstance)
		if (!newArticle?.getId()) {
			render(view: "create", model: [articleInstance: articleInstance])
			return
		}
		flash.message = message(code: 'default.created.message', args: [
			message(code: 'article.label', default: 'Article'),
			newArticle.getId()
		])
		redirect(action: "list")
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def edit(Long id) {
		def articleInstance = articleService.getById((Integer.parseInt(params.get("id"))))

		[articleInstance: articleInstance,laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def update(Long id) {
		def articleInstance = articleService.getById(Integer.parseInt(params.get("edit")))
		System.out.println(articleInstance.getId())
		articleInstance.setName(params.get("name"))
		articleInstance.setDescription(params.get("description"))
		articleInstance.setUnits(params.get("units"))
		articleService.save(articleInstance)
		redirect(action: "list")
	}
	
	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def selectArticle() {
		def doctors = articleService.find(params.get("q"), 0, 0)
		render doctors as JSON
	}
}
