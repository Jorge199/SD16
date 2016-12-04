package com.sd.uni.labpatologia.doctor

import grails.converters.JSON
import grails.converters.XML
import grails.plugin.springsecurity.annotation.Secured;

import com.sd.uni.labpatologia.beans.doctor.DoctorB
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.doctor.DoctorServiceImpl
import com.sd.uni.labpatologia.service.doctor.IDoctorService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.beans.factory.annotation.Autowired;


class DoctorController {
	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	//services
	def IDoctorService doctorService
	def ILaboratoryService laboratoryService
	@Autowired def IAuthService authService

	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def create(){
		[doctorInstance: new DoctorB(params),laboratoryInstanceList: laboratoryService.getAll(),
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
		def doctors = null
		if(null != text && !"".equals(text)){
			doctors = doctorService.find(text,10,page)
			siguiente = doctorService.find(text,10,page+1)
		}else{
			doctors = doctorService.find(null,10,page)
			siguiente = doctorService.find(null,10,page+1)
		}

		[doctorInstanceList: doctors, doctorInstanceTotal: doctors?.size(), page: page, siguiente: siguiente?.size(),laboratoryInstanceList: laboratoryService.getAll(), text: text,
			user:authService.getName()]
	}
	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def save() {
		def doctorInstance = new DoctorB(params)
		def newDoctor = doctorService.save(doctorInstance)
		if (!newDoctor?.getId()) {
			render(view: "create", model: [doctorInstance: doctorInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'doctor.label', default: 'Doctor'), newDoctor.getId()])
		redirect(action: "list", id: newDoctor.getId())
	}

	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def edit(Integer id) {
		def doctorInstance = doctorService.getById(Integer.parseInt(params.get("id")))
		//si no existe esa id
		if (!doctorInstance) {
			flash.message = message(code: 'default.not.found.message', args: [message(code: 'doctor.label', default: 'Doctor'), id])
			redirect(action: "list")
			return
		}
		[doctorInstance: doctorInstance,laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}
	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def update(Integer id) {
		def doctorInstance = new DoctorB(params)
		doctorInstance.setId(Integer.parseInt(params.get("edit")))
		doctorInstance.setAddress(params.get("address"))
		doctorInstance.setEmail(params.get("email"))
		doctorInstance.setName(params.get("name"))
		doctorInstance.setCi(params.get("ci"))
		doctorInstance.setLastName(params.get("last_name"))
		doctorInstance.setPhone(params.get("phone"))
		doctorInstance.setSpeciality(params.get("speciality"))
		doctorService.save(doctorInstance)
		redirect(action: "list")
	}
	
	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def selectDoctor() {
		def doctors = doctorService.find(params.get("q"), 0, 0)
		render doctors as JSON
	}

}
