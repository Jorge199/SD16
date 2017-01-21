package com.sd.uni.labpatologia.laboratory
import grails.plugin.springsecurity.annotation.Secured;

import com.sd.uni.labpatologia.beans.laboratory.LaboratoryB
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService





import org.springframework.dao.DataIntegrityViolationException
import org.springframework.beans.factory.annotation.Autowired;

import sistema.InicioController;


class LaboratoryController {
	static allowedMethods = [save: "POST", update: "POST"]

	//service
	def ILaboratoryService laboratoryService;
	@Autowired def IAuthService authService

	def index() {
		redirect(action: "list", params: params)
	}
	@Secured([
		'ROLE_ADMINISTRADOR'
	])
	def _show() {
		def text = params.text
		def laboratories = null
		if(null != text && !"".equals(text)){
			laboratories = laboratoryService.find(text)
			System.out.println("ingresado"+text)
			System.out.println("busqueda"+laboratories)
		}else{
			laboratories = laboratoryService.getAll()
		}

		System.out.println("Cantidad Laboratorios----------------------------->"+laboratories.size())
		[laboratoryInstanceList: laboratories, reportInstanceTotal: laboratories?.size()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
	def edit(Integer id) {
		def laboratoryInstance = laboratoryService.getById(Integer.parseInt(params.get("id")))
		//si no existe esa id
		if (!laboratoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'laboratory.label', default: 'Laboratory'),
				id
			])
			redirect(uri: "/inicio/index")
			return
		}
		[laboratoryInstance: laboratoryInstance,laboratoryInstanceList: laboratoryService.getAll()]
	}
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
	def update(Integer id) {
		def laboratoryInstance = new LaboratoryB(params)
		laboratoryInstance.setId(Integer.parseInt(params.get("edit")))
		laboratoryInstance.setAddress(params.get("address"))
		laboratoryInstance.setEmail(params.get("email"))
		laboratoryInstance.setName(params.get("name"))
		laboratoryInstance.setPhone(params.get("phone"))
		laboratoryService.save(laboratoryInstance)
		redirect(uri: "/inicio/index")
	}




}

