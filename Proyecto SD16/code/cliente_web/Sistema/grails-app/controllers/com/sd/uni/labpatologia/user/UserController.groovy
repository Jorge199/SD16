package com.sd.uni.labpatologia.user


import org.springframework.dao.DataIntegrityViolationException

import com.sd.uni.labpatologia.beans.user.UserB
import com.sd.uni.labpatologia.service.rol.*
import com.sd.uni.labpatologia.service.user.*

class UserController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//service
	def IUserService userService =new UserServiceImpl()
	def IRolService rolService=new RolServiceImpl()

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		def text = params.text
		userService=new UserServiceImpl()
		def users = userService.getAll()
		
		if(null != text && !"".equals(text)){
			
			users = userService.find(text)
			
			
			
		}else{
			users = userService.getAll()
		}
		
		
		[userInstanceList: users, userInstanceTotal:users.size()]
	}
	
	def list2(Integer max) {
		def text = params.text
		userService=new UserServiceImpl()
		def users = userService.getAll()
		
		if(null != text && !"".equals(text)){
			users = userService.find(text)
			
		}else{
			users = userService.getAll()
		}
		
		
		[userInstanceList: users, userInstanceTotal:users.size()]
	}
	
	
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

	
	

	def create() {
		[userInstance: new UserB(params), rols:rolService.getAll()]
	}

	def save() {
		def newUser = new UserB(params)
		newUser.setRol(rolService.getById(Integer.valueOf(params.rolId)))
		def userInstance = userService.save(newUser)
		if (!userInstance.getId()) {
			render(view: "create", model: [userInstance: userInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'user.label', default: 'User'),
			userInstance.getId()
		])
		redirect(action: "show", id: userInstance.getId())
	}
	
	
	
	
	

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

	def edit(Long id) {
		def userInstance = userService.getById(id.intValue())
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
			return
		}

		[userInstance: userInstance, rols:rolService.getAll()]
	}

	

	def update(Integer id) {
		def userInstance = new UserB(params)
		userInstance.setId(id)
		userInstance.setName(params.get("name"))
		userInstance.setPassword(params.get("password"))
		userInstance.setDoctor( Boolean.valueOf(params.get("doctor")))
		userInstance.setMatricula(params.get("matricula"))
		userInstance.setRol(rolService.getById(Integer.valueOf(params.rolId)))
		userService.save(userInstance)
		redirect(action: "list")
	}

	
	def delete(Long id) {
		def userInstance = userService.getById(id.intValue())
		if (!userInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			userInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'user.label', default: 'User'),
				id
			])
			redirect(action: "show", id: id)
		}
	}
}