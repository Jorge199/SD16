package com.sd.uni.labpatologia.laboratory
import com.sd.uni.labpatologia.beans.laboratory.LaboratoryB


import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService


import org.springframework.dao.DataIntegrityViolationException
import org.springframework.beans.factory.annotation.Autowired;


class LaboratoryController {
	static allowedMethods = [save: "POST", update: "POST"]
	
	//service
	def ILaboratoryService laboratoryService;
	
	def index() {
		redirect(action: "list", params: params)
	}
	
	def list() {
		def laboratories = laboratoryService.getAll()
	
		System.out.println("Cantidad Laboratorios----------------------------->"+laboratories.size())
		[laboratoryInstanceList: laboratories, reportInstanceTotal: laboratories?.size()]
	}
	
	def create(Integer id) {
		def laboratoryInstance = new LaboratoryB(params)
		[laboratoryInstance: laboratoryInstance] //, requests:requestService.getAll()]
	}
	def save(Integer id) {
		
		def laboratoryInstance = new LaboratoryB(params)
	
		def newLaboratory = laboratoryService.save(laboratoryInstance)
		if (!newLaboratory?.getId()) {
			//redirect(action: "list", id: newReport.getId())
			//return
		}
		redirect(action: "list", id: newLaboratory.getId())
	}
	
	def show(long id){
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
	
	def edit(Integer id) {
		def laboratoryInstance = laboratoryService.getById(Integer.parseInt(params.get("id")))
				//si no existe esa id
				if (!laboratoryInstance) {
					flash.message = message(code: 'default.not.found.message', args: [
						message(code: 'laboratory.label', default: 'Laboratory'),
						id
					])
					redirect(action: "show")
					return
				}
		[laboratoryInstance: laboratoryInstance]
	}
	
	def update(Integer id) {
		def laboratoryInstance = new LaboratoryB(params)
		laboratoryInstance.setId(Integer.parseInt(params.get("edit")))
		laboratoryInstance.setAddress(params.get("address"))
		laboratoryInstance.setEmail(params.get("email"))
		laboratoryInstance.setName(params.get("name"))
		laboratoryInstance.setPhone(params.get("phone"))
		laboratoryService.save(laboratoryInstance)
		redirect(action: "list")
	}


	

}

