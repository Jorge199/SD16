package com.sd.uni.labpatologia.rol


import org.springframework.dao.DataIntegrityViolationException

import com.sd.uni.labpatologia.beans.rol.RolB
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.service.rol.*


class RolController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//service
	def IRolService rolService =new RolServiceImpl()
	def ILaboratoryService laboratoryService

	def index() {
		redirect(action: "list", params: params)
	}

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

	
	

	def create() {
		[rolInstance: new RolB(params), rols:rolService.getAll(),laboratoryInstanceList: laboratoryService.getAll()]
	}

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

	

	def update(Integer id) {
		def rolInstance = new RolB(params)
		rolInstance.setId(id)
		rolInstance.setName(params.get("name"))
		
		rolService.save(rolInstance)
		redirect(action: "list")
	}

	
	def delete(Long id) {
		def rolInstance = rolService.getById(id.intValue())
		if (!rolInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'rol.label', default: 'Rol'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			rolInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'rol.label', default: 'Rol'),
				id
			])
			redirect(action: "list")
		}
		catch (DataIntegrityViolationException e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'rol.label', default: 'Rol'),
				id
			])
			redirect(action: "show", id: id)
		}
	}
}
