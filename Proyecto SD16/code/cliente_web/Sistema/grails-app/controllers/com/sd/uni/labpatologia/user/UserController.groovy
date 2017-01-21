package com.sd.uni.labpatologia.user


import grails.plugin.springsecurity.annotation.Secured;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException

import com.sd.uni.labpatologia.beans.user.UserB
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.service.rol.*
import com.sd.uni.labpatologia.service.user.*

class UserController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//service
	def IUserService userService =new UserServiceImpl()
	def IRolService rolService=new RolServiceImpl()
	def ILaboratoryService laboratoryService
	@Autowired def IAuthService authService

	def index() {
		redirect(action: "list", params: params)
	}

	@Secured([
		'ROLE_ADMINISTRADOR',
		'ROLE_DOCTOR'
	])

	def list(Integer max) {
		def page = 0
		def siguiente
		if(null != params.get("page")){
			page = Integer.parseInt(params.get("page"))
		}
		def text = params.text
		userService=new UserServiceImpl()
		def users = userService.getAll()

		if(null != text && !"".equals(text)){
			users = userService.find(text,10,page)
			siguiente = userService.find(text,10,page+1)
		}else{
			users = userService.find(null,10,page)
			siguiente = userService.find(null,10,page+1)
		}

		[userInstanceList: users, userInstanceTotal:users.size(), page: page, siguiente: siguiente?.size(),
			text:text, laboratoryInstanceList: laboratoryService.getAll(), user:authService.getName()]
	}


	@Secured([
		'ROLE_ADMINISTRADOR',
		'ROLE_DOCTOR'
	])

	def showResult(Integer max) {
		def text = params.text
		userService=new UserServiceImpl()
		def users = userService.getAll()

		if(null != text && !"".equals(text)){
			users = userService.find(text)

		}else{
			users = userService.getAll()
		}

		render (template:"showResult", model:[userInstanceList: users, userInstanceTotal:users.size()])
	}



	@Secured(['ROLE_ADMINISTRADOR'])

	def create() {
		def rols = rolService.getAll();
		for(roles in rols){
			roles._name=roles._name.charAt(5).toString()+roles._name.substring(6,roles.name.length()).toLowerCase()
		}
		[userInstance: new UserB(params), rols:rols,laboratoryInstanceList: laboratoryService.getAll(), user:authService.getName()]
	}

	@Secured(['ROLE_ADMINISTRADOR'])

	def save() {
		def newUser = new UserB(params)
		newUser.setRol(rolService.getById(Integer.valueOf(params.rolId)))
		newUser.setPassword(params.get("password"))
		def userInstance = userService.save(newUser)
		if (!userInstance.getId()) {
			render(view: "create", model: [userInstance: userInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'user.label', default: 'User'),
			userInstance.getId()
		])
		redirect(action: "list")
	}



	@Secured([
		'ROLE_ADMINISTRADOR',
		'ROLE_DOCTOR'
	])
	def show(Long id) {
		def userInstance = userService.getById(id.intValue())
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
			return
		}

		[userInstance: userInstance]
	}

	@Secured([
		'ROLE_ADMINISTRADOR',
		'ROLE_DOCTOR'
	])

	def edit(Long id) {
		def userInstance = userService.getById(id.intValue())
		def rols = rolService.getAll()
		for(roles in rols){
			roles._name=roles._name.charAt(5).toString()+roles._name.substring(6,roles.name.length()).toLowerCase()
		}
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
			return
		}

		[userInstance: userInstance, rols:rols,laboratoryInstanceList: laboratoryService.getAll(), user:authService.getName()]
	}


	@Secured([
		'ROLE_ADMINISTRADOR',
		'ROLE_DOCTOR'
	])

	def update(Integer id) {
		def userInstance = new UserB(params)
		userInstance.setId(Integer.parseInt(params.get("edit")))
		//userInstance.setName(params.get("name"))
		//userInstance.setUserName(params.get("userName"))
		//userInstance.setPassword(params.get("password"))
		//userInstance.setRegistrationNumber(params.get("registrationNumber"))
		userInstance.setRol(rolService.getById(Integer.valueOf(params.rolId)))
		userService.save(userInstance)
		redirect(action: "list")
	}

}