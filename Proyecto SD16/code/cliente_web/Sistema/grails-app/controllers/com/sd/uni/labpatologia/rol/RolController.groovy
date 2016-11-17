package com.sd.uni.labpatologia.rol


import grails.plugin.springsecurity.annotation.Secured;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException

import com.sd.uni.labpatologia.beans.rol.RolB
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.service.rol.*


class RolController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//service
	def IRolService rolService =new RolServiceImpl()
	def ILaboratoryService laboratoryService
	@Autowired def IAuthService authService
	@Secured(['ROLE_ADMINISTRADOR'])
	def index() {
		redirect(action: "list", params: params)
	}
	@Secured(['ROLE_ADMINISTRADOR'])

	def list(Integer max) {
		def text = params.text
		rolService=new RolServiceImpl()
		def rols = rolService.getAll()

		if(null != text && !"".equals(text)){

			rols = rolService.find(text)



		}else{
			rols = rolService.getAll()
		}


		[rolInstanceList: rols, rolInstanceTotal:rols.size(),laboratoryInstanceList: laboratoryService.getAll()]
	}
	@Secured(['ROLE_ADMINISTRADOR'])

	def list2(Integer max) {
		def text = params.text
		rolService=new RolServiceImpl()
		def rols = rolService.getAll()

		if(null != text && !"".equals(text)){
			rols = rolService.find(text)

		}else{
			rols = rolService.getAll()
		}


		[rolInstanceList: rols, rolInstanceTotal:rols.size(),laboratoryInstanceList: laboratoryService.getAll()]
	}


	@Secured(['ROLE_ADMINISTRADOR'])
	def showResult(Integer max) {
		def text = params.text
		rolService=new RolServiceImpl()
		def rols = rolService.getAll()

		if(null != text && !"".equals(text)){
			rols = rolService.find(text)

		}else{
			rols = rolService.getAll()
		}


		[rolInstanceList: rols, rolInstanceTotal:rols.size()]
	}




	@Secured(['ROLE_ADMINISTRADOR'])
	def create() {
		[rolInstance: new RolB(params), rols:rolService.getAll(),laboratoryInstanceList: laboratoryService.getAll()]
	}

	@Secured(['ROLE_ADMINISTRADOR'])
	def save() {
		def newRol = new RolB(params)
		def rolInstance = rolService.save(newRol)
		if (!rolInstance.getId()) {
			render(view: "create", model: [rolInstance: rolInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'rol.label', default: 'Rol'),
			rolInstance.getId()
		])
		redirect(action: "show", id: rolInstance.getId())
	}





	@Secured(['ROLE_ADMINISTRADOR'])
	
	def show(Long id) {
		def rolInstance = rolService.getById(id.intValue())
		if (!rolInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'rol.label', default: 'Rol'),
				id
			])
			redirect(action: "list")
			return
		}

		[rolInstance: rolInstance]
	}
	@Secured(['ROLE_ADMINISTRADOR'])
	
	def edit(Long id) {
		def rolInstance = rolService.getById(id.intValue())
		if (!rolInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'rol.label', default: 'Rol'),
				id
			])
			redirect(action: "list")
			return
		}

		[rolInstance: rolInstance, rols:rolService.getAll(),laboratoryInstanceList: laboratoryService.getAll()]
	}


	@Secured(['ROLE_ADMINISTRADOR'])
	
	def update(Integer id) {
		def rolInstance = new RolB(params)
		rolInstance.setId(id)
		rolInstance.setName(params.get("name"))

		rolService.save(rolInstance)
		redirect(action: "list")
	}

}
