package com.sd.uni.labpatologia.patient
import com.sd.uni.labpatologia.beans.patient.PatientB
import com.sd.uni.labpatologia.service.patient.*
import com.sd.uni.labpatologia.util.SexEnum;

import java.text.SimpleDateFormat

import org.springframework.dao.DataIntegrityViolationException
import org.springframework.beans.factory.annotation.Autowired;


class PatientController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
	//services
	def IPatientService patientService=new PatientServiceImpl()

	def index() {
		redirect(action: "list", params: params)
	}
	def create(){
		[patientInstance: new PatientB(params)]
	}

	def list(Integer max) {
		def text = params.text
		def patients = null
		if(null != text && !"".equals(text)){
			patients = patientService.find(text,10,0)//getAll()//find(text,10,0)
		}else{
			patients = patientService.getAll()//find("all",10,0)
		}		
		[patientInstanceList: patients, patientInstanceTotal: patients?.size()]
	}

	def save() {
		def patientInstance = new PatientB(params)
		
		if(""!=params.get("birthDate")){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			patientInstance.setBirthDate(formatter.parse(params.get("birthDate")));
		}
		
		
		try{
			patientInstance.setSex(SexEnum.valueOf(params.get("sex")))
		}catch(NullPointerException n){
			n.printStackTrace()
		}
		//patientInstance.setSex(params.get("sex"))
		def newPatient = patientService.save(patientInstance)
		if (!newPatient?.getId()) {
			render(view: "create", model: [patientInstance: patientInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'patient.label', default: 'Patient'),
			newPatient.getId()
		])
		redirect(action: "list")
	}


	def edit(Long id) {
		def patientInstance = patientService.getById((Integer.parseInt(params.get("id"))))
		
		[patientInstance: patientInstance]
	}

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
			patientInstance.setSex(SexEnum.valueOf(params.get("sex")))
		}catch(NullPointerException n){
			n.printStackTrace()
		}
		
		patientService.save(patientInstance)
		redirect(action: "list")

	}



}

