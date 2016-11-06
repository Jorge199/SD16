package com.sd.uni.labpatologia.doctor

import com.sd.uni.labpatologia.beans.doctor.DoctorB
import com.sd.uni.labpatologia.service.doctor.IDoctorService

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.beans.factory.annotation.Autowired;


class DoctorController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	//services
	def IDoctorService doctorService
	
	
	def index() {
		redirect(action: "list", params: params)
	}
	def create(){
		[doctorInstance: new DoctorB(params)]
	}
	
	def list(Integer max) {
		def doctors = doctorService.getAll()
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

	def edit(Long id) {
		def doctorInstance = doctorService.getById(id.intValue())
		if (!doctorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'doctor.label', default: 'Doctor'),
				id
			])
			redirect(action: "list")
			return
		}

		[doctorInstance: doctorInstance]
	}

	def update(Long id, Long version) {
		def doctorInstance = doctorService.getById(id.intValue())
		if (!doctorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'doctor.label', default: 'Doctor'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (doctorInstance.version > version) {
				doctorInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'doctor.label', default: 'Doctor')] as Object[],
						"Another user has updated this Client while you were editing")
				render(view: "edit", model: [doctorInstance: doctorInstance])
				return
			}
		}

		doctorInstance.properties = params

		if (!doctorInstance.save(flush: true)) {
			render(view: "edit", model: [doctorInstance: doctorInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'doctor.label', default: 'Doctor'),
			doctorInstance.id
		])
		redirect(action: "show", id: doctorInstance.id)
	}

	

}
