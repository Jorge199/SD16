package com.sd.uni.labpatologia.patient
import com.sd.uni.labpatologia.beans.patient.PatientB
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.service.patient.*
import com.sd.uni.labpatologia.util.SexEnum;

import grails.converters.JSON
import grails.plugin.springsecurity.annotation.Secured;

import java.text.SimpleDateFormat

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.beans.factory.annotation.Autowired;


class PatientController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	//services
	def IPatientService patientService=new PatientServiceImpl()
	def ILaboratoryService laboratoryService
	@Autowired def IAuthService authService

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def index() {
		redirect(action: "list", params: params)
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def create(){
		[patientInstance: new PatientB(params),laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def list(Integer max) {
		def page = 0
		def siguiente
		if(null != params.get("page")){
			page = Integer.parseInt(params.get("page"))
		}
		def text = params.text
		def search = ""
		if(null!=params.get("text") && !"".equals(params.get("text")) && !"null".equals(params.get("text"))){
			search += "text="+params.text+'&'
		}
		if(null!=params.get("sort") && !"".equals(params.get("sort")) && !"null".equals(params.get("sort"))){
			search +="sort="+params.get("sort")+'&'
		}
		if(null!=params.get("order") && !"".equals(params.get("order")) && !"null".equals(params.get("order"))){
			search +="order="+params.get("order")+'&'
		}
		def patients = null
		if(null != search && !"".equals(search)){	
			patients = patientService.find(search,10,page)
			siguiente = patientService.find(search,10,page+1)
		}else{
			patients = patientService.find(null,10,page)
			siguiente = patientService.find(null,10,page+1)
		}
		[patientInstanceList: patients, patientInstanceTotal: patients?.size(), page: page, siguiente: siguiente?.size(), text: text, laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def save() {
		def patientInstance = new PatientB(params)

		if(""!=params.get("birthDate")){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			patientInstance.setBirthDate(formatter.parse(params.get("birthDate")));
		}


		try{
			patientInstance.setSex(SexEnum.valueOf(params.get("sex").toUpperCase()))
		}catch(NullPointerException n){
			n.printStackTrace()
		}
		//patientInstance.setSex(params.get("sex"))
		def newPatient = patientService.save(patientInstance)
		if (!newPatient?.getId()) {
			render(view: "create", model: [patientInstance: patientInstance])
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'patient.label', default: 'Patient'),
			newPatient.getId()
		])
		redirect(action: "list")
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def edit(Long id) {
		def patientInstance = patientService.getById((Integer.parseInt(params.get("id"))))

		[patientInstance: patientInstance,laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def update(Long id) {
		def patientInstance = patientService.getById(Integer.parseInt(params.get("edit")))
		System.out.println(patientInstance.getId())
		if(""!=params.get("birthDate")){
			System.out.println("actualizo fecha")
			System.out.println(null==params.get("birthDate"))
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			patientInstance.setBirthDate(formatter.parse(params.get("birthDate")));
		}
		try{
			patientInstance.setSex(SexEnum.valueOf(params.get("sex").toUpperCase()))
		}catch(NullPointerException n){
			n.printStackTrace()
		}
		patientInstance.setName(params.get("name"))
		patientInstance.setLastName(params.get("lastName"))
		patientInstance.setDocument(params.get("document"))
		patientInstance.setAddress(params.get("address"))
		patientInstance.setPhone(params.get("phone"))
		patientInstance.setAddress(params.get("address"))
		patientInstance.setMail(params.get("mail"))
		patientService.save(patientInstance)
		redirect(action: "list")

	}

	@Secured(['ROLE_DOCTOR', 'ROLE_ADMINISTRADOR', 'ROLE_SECRETARIA'])
	def selectPatient() {
		def patients = patientService.find("text="+params.get("q"), 0, 0)
		render patients as JSON
	}
}

