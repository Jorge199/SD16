package com.sd.uni.labpatologia.request

import grails.plugin.springsecurity.annotation.Secured

import java.text.SimpleDateFormat

import com.sd.uni.labpatologia.beans.request.RequestB
import com.sd.uni.labpatologia.service.doctor.IDoctorService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.service.patient.IPatientService
import com.sd.uni.labpatologia.service.request.IRequestService
import com.sd.uni.labpatologia.service.study_type.IStudyTypeService
import com.sd.uni.labpatologia.service.user.IUserService
import com.sd.uni.labpatologia.util.StatusEnum

class RequestController {

	static allowedMethods = [save: "POST", update: "POST"]

	//services
	def IRequestService requestService
	def IDoctorService doctorService
	def IPatientService patientService
	def IStudyTypeService studyTypeService
	def IUserService userService
	def ILaboratoryService laboratoryService

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def index() {
		redirect(action: "list",params: params)
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def list() {
		def page = 0
		def siguiente
		if(null != params.get("page")){
			page = Integer.parseInt(params.get("page"))
		}
		def requests = null
		String textToFind=""
		if (params.containsKey("text")){
			textToFind= params.get("text");
		}else{
			if(null!=params.get("statusSearch") && !"".equals(params.get("statusSearch")) && !"null".equals(params.get("statusSearch"))){
				textToFind+="status="+params.get("statusSearch")+'&'
			}
			if((!"".equals(params.get("startSearch"))) && !"".equals(params.get("endSearch")) && (null != params.get("startSearch")) && (null != params.get("endSearch"))){
				textToFind+="start="+params.get("startSearch")+'&'
				textToFind+="end="+params.get("endSearch")
			}else{
				if((null != params.get("startSearch")) && !"".equals(params.get("startSearch"))){
					textToFind+="date="+params.get("startSearch")
				}
			}
		}
		if(!textToFind.equals("")){
			requests = requestService.find(textToFind,10,page)
			siguiente = requestService.find(textToFind,10,page+1)
		}else{
			requests = requestService.find(null,10,page)
			siguiente = requestService.find(null,10,page+1)
		}
		System.out.println("Cantidad Solicitudes----------------------------->"+requests.size())
		[requestInstanceList: requests, requestInstanceTotal: requests?.size(), patients: patientService.getAll(), doctors: doctorService.getAll(), studies: studyTypeService.getAll(), page: page, siguiente: siguiente?.size(),laboratoryInstanceList: laboratoryService.getAll(), text: textToFind]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def create() {
		def requestInstance = new RequestB(params)
		[requestInstance: requestInstance, patients: patientService.getAll(), doctors: doctorService.getAll(), studies: studyTypeService.getAll(),laboratoryInstanceList: laboratoryService.getAll()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def save(Integer id) {

		def requestInstance = new RequestB(params)
		if(""!=params.get("date")){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			requestInstance.setDate(formatter.parse(params.get("date")));
		}
		requestInstance.setStudyType(studyTypeService.getById(Integer.parseInt(params.get("studyTypeId"))))
		requestInstance.setDoctor(doctorService.getById(Integer.parseInt(params.get("doctorId"))))
		requestInstance.setPatient(patientService.getById(Integer.parseInt(params.get("patientId"))))
		requestInstance.setStatus(StatusEnum.RECIBIDO)
		def newRequest= requestService.save(requestInstance)
		if (!newRequest?.getId()) {
			//redirect(action: "list", id: newReport.getId())
			//return
		}
		redirect(action: "list", id: newRequest.getId())
	}

		@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def edit(Integer id) {
		def requestInstance = requestService.getById(Integer.parseInt(params.get("id")))
		//si no existe esa id
		if (!requestInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'request.label', default: 'Request'),
				id
			])
			redirect(action: "list")
			return
		}
		[requestInstance: requestInstance, patients: patientService.getAll(), doctors: doctorService.getAll(), studies: studyTypeService.getAll(),laboratoryInstanceList: laboratoryService.getAll()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR'
	])
	def update(Integer id) {
		def requestInstance = requestService.getById(Integer.parseInt(params.get("edit")))
		if(""!=params.get("date")){
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			requestInstance.setDate(formatter.parse(params.get("date")));
		}
		requestInstance.setStudyType(studyTypeService.getById(Integer.parseInt(params.get("studyTypeId"))))
		requestInstance.setDoctor(doctorService.getById(Integer.parseInt(params.get("doctorId"))))
		requestInstance.setPatient(patientService.getById(Integer.parseInt(params.get("patientId"))))
		requestInstance.setCode(params.get("code"))
		if (!"".equals(params.get("code1")) && (null != params.get("status")) && params.containsKey("code1")){
			requestInstance.setCode(params.get("code")+"/"+params.get("code1"))
			requestInstance.setStatus(StatusEnum.valueOf(params.get("status")))
		}
		requestInstance.setNote(params.get("note"))
		requestService.save(requestInstance)
		redirect(action: "list")
	}
}