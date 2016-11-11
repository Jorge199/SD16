package com.sd.uni.labpatologia.doctor

import com.sd.uni.labpatologia.beans.doctor.DoctorB
import com.sd.uni.labpatologia.service.doctor.DoctorServiceImpl
import com.sd.uni.labpatologia.service.doctor.IDoctorService

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.beans.factory.annotation.Autowired;


class DoctorController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	//services
	def IDoctorService doctorService
	
	
	
	def create(){
		[doctorInstance: new DoctorB(params)]
	}
	
	def list(Integer max) {
		def text = params.text
		def doctors = null
		if(null != text && !"".equals(text)){
			doctors = doctorService.find(text,10,0)
		}else{
			doctors = doctorService.find("all",10,0)
		}
			
		[doctorInstanceList: doctors, doctorInstanceTotal: doctors?.size()]
	}
	
	def save() {
		def doctorInstance = new DoctorB(params)
		def newDoctor = doctorService.save(doctorInstance)
		if (!newDoctor?.getId()) {
			render(view: "create", model: [doctorInstance: doctorInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'doctor.label', default: 'Doctor'),
			newDoctor.getId()
		])
		redirect(action: "show", id: newDoctor.getId())
	}
	def show(Long id) {
		def doctorInstance = doctorService.getById(id.intValue())
		if (!doctorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'doctor.label', default: 'Doctor'),
				id
			])
		}
		[doctorInstance: doctorInstance]
	}

	def edit(Integer id) {
		def doctorInstance = doctorService.getById(Integer.parseInt(params.get("id")))
				//si no existe esa id
				if (!doctorInstance) {
					flash.message = message(code: 'default.not.found.message', args: [
						message(code: 'doctor.label', default: 'Doctor'),
						id
					])
					redirect(action: "show")
					return
				}
		[doctorInstance: doctorInstance]
	}
	
	def update(Integer id) {
		def doctorInstance = new DoctorB(params)
		doctorInstance.setId(Integer.parseInt(params.get("edit")))
		doctorInstance.setAddress(params.get("address"))
		doctorInstance.setEmail(params.get("email"))
		doctorInstance.setName(params.get("name"))
                doctorInstance.setLastName(params.get("last_name"))
                doctorInstance.setCi(Integer.parseInt(params.get("ci")))
		doctorInstance.setPhone(params.get("phone"))
		doctorService.save(doctorInstance)
		redirect(action: "list")
	}

	

}
