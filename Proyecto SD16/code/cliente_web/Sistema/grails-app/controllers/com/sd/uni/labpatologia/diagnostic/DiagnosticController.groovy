package com.sd.uni.labpatologia.diagnostic

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured

import org.springframework.beans.factory.annotation.Autowired

import com.sd.uni.labpatologia.beans.diagnostic.DiagnosticB
import com.sd.uni.labpatologia.service.auth.IAuthService
import com.sd.uni.labpatologia.service.diagnostic.IDiagnosticService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService


class DiagnosticController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	//services
	def IDiagnosticService diagnosticService
	def ILaboratoryService laboratoryService	
	@Autowired def IAuthService authService

	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def create(){
		[diagnosticInstance: new DiagnosticB(params),laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}
	
	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def list(Integer max) {
		def page = 0
		def siguiente
		if(null != params.get("page")){
			page = Integer.parseInt(params.get("page"))
		}
		def text = params.text
		def search = ""
		def diagnostics = null
		
		if(null!=params.get("text") && !"".equals(params.get("text")) && !"null".equals(params.get("text"))){
			search += "text="+params.text+'&'
		}
		if(null!=params.get("sort") && !"".equals(params.get("sort")) && !"null".equals(params.get("sort"))){
			search +="sort="+params.get("sort")+'&'
		}
		if(null!=params.get("order") && !"".equals(params.get("order")) && !"null".equals(params.get("order"))){
			search +="order="+params.get("order")+'&'
		}
		
		if(null != search && !"".equals(search)){
			diagnostics = diagnosticService.find(search,10,page)
			siguiente = diagnosticService.find(search,10,page+1)
		}else{
			diagnostics = diagnosticService.find(null,10,page)
			siguiente = diagnosticService.find(null,10,page+1)
		}

		[diagnosticInstanceList: diagnostics, diagnosticInstanceTotal: diagnostics?.size(), page: page, siguiente: siguiente?.size(),laboratoryInstanceList: laboratoryService.getAll(), text: text,
			user:authService.getName()]
	}
	
	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def save() {
		def diagnosticInstance = new DiagnosticB(params)
		def newDiagnostic = diagnosticService.save(diagnosticInstance)
		if (!newDiagnostic?.getId()) {
			render(view: "create", model: [diagnosticInstance: diagnosticInstance])
			return
		}

		redirect(action: "list", id: newDiagnostic.getId())
	}

	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def edit(Integer id) {
		def diagnosticInstance = diagnosticService.getById(Integer.parseInt(params.get("id")))
		//si no existe esa id

		[diagnosticInstance: diagnosticInstance,laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}
	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def update(Integer id) {
		def diagnosticInstance = diagnosticService.getById(Integer.parseInt(params.get("edit")))
		
		diagnosticInstance.setId(Integer.parseInt(params.get("edit")))
		diagnosticInstance.setName(params.get("name"))
		diagnosticInstance.setDescription(params.get("description"))
		diagnosticService.save(diagnosticInstance)
		redirect(action: "list")
	}
	
	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def selectDiagnostic() {
		def diagnostics = diagnosticService.find("text="+params.get("q"), 0, 0)
		render diagnostics as JSON
	}

}
