package com.sd.uni.labpatologia.laboratory
import com.sd.uni.labpatologia.beans.laboratory.LaboratoryB
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.beans.factory.annotation.Autowired;


class LaboratoryController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	//services
	def ILaboratoryService laboratoryService
	
	
	def index() {
		redirect(action: "list", params: params)
	}
	def create(){
		[laboratoryInstance: new LaboratoryB(params)]
	}
	
	def list(Integer max) {
		def laboratories = laboratoryService.getAll()
		[laboratoryInstanceList: laboratories, laboratoryInstanceTotal: laboratories?.size()]
	}
	
	def save() {
		def laboratoryInstance = new LaboratoryB(params)
		def newLaboratory = laboratoryService.save(laboratoryInstance)
		if (!newLaboratory?.getId()) {
			render(view: "create", model: [laboratoryInstance: laboratoryInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'laboratory.label', default: 'Laboratory'),
			newLaboratory.getId()
		])
		redirect(action: "show", id: newLaboratory.getId())
	}
	def show(Long id) {
		def laboratoryInstance = laboratoryService.getById(id.intValue())
		if (!laboratoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'laboratory.label', default: 'Laboratory'),
				id
			])
		}
		[laboratoryInstance: laboratoryInstance]
	}

	def edit(Long id) {
		def laboratoryInstance = laboratoryService.getById(id.intValue())
		if (!laboratoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'laboratory.label', default: 'Laboratory'),
				id
			])
			redirect(action: "list")
			return
		}

		[laboratoryInstance: laboratoryInstance]
	}

	def update(Long id, Long version) {
		def laboratoryInstance = laboratoryService.getById(id.intValue())
		if (!laboratoryInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'laboratory.label', default: 'Laboratory'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (laboratoryInstance.version > version) {
				laboratoryInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'laboratory.label', default: 'Laboratory')] as Object[],
						"Another user has updated this Client while you were editing")
				render(view: "edit", model: [laboratoryInstance: laboratoryInstance])
				return
			}
		}

		laboratoryInstance.properties = params

		if (!laboratoryInstance.save(flush: true)) {
			render(view: "edit", model: [laboratoryInstance: laboratoryInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'laboratory.label', default: 'Laboratory'),
			laboratoryInstance.id
		])
		redirect(action: "show", id: laboratoryInstance.id)
	}

	

}
