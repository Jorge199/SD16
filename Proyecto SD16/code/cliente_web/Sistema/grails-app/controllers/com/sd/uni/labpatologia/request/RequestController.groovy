package com.sd.uni.labpatologia.request

import grails.plugin.springsecurity.annotation.Secured

import java.text.SimpleDateFormat

import org.springframework.beans.factory.annotation.Autowired;

import com.itextpdf.text.io.GetBufferedRandomAccessSource
import com.sd.uni.labpatologia.beans.request.RequestB
import com.sd.uni.labpatologia.service.auth.IAuthService;
import com.sd.uni.labpatologia.service.doctor.IDoctorService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService
import com.sd.uni.labpatologia.service.patient.IPatientService
import com.sd.uni.labpatologia.service.report.IReportService;
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
	def IReportService reportService
	@Autowired def IAuthService authService


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
		System.out.println("principio")
		String textToFind=""
		System.out.println(params)
		if (params.containsKey("text")){
			textToFind= params.get("text")
			System.out.println("no entro else" + textToFind)
		}else{
			if(null!=params.get("specimen") && !"".equals(params.get("specimen")) && !"null".equals(params.get("specimen"))){
				textToFind+="specimen="+params.get("specimen")+'&'
			}
			if(null!=params.get("code") && !"".equals(params.get("code")) && !"null".equals(params.get("code"))){
				textToFind+="code="+params.get("code")+'&'
			}
			if(null!=params.get("patient") && !"".equals(params.get("patient")) && !"null".equals(params.get("patient"))){
				textToFind+="patient="+params.get("patient")+'&'
			}
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
			System.out.println("entro else" + textToFind)
		}
		System.out.println("text" + textToFind)
		if(!textToFind.equals("")){
			requests = requestService.find(textToFind,10,page)
			siguiente = requestService.find(textToFind,10,page+1)
		}else{
			requests = requestService.find(null,10,page)
			siguiente = requestService.find(null,10,page+1)
		}
		System.out.println("Cantidad Solicitudes----------------------------->"+requests.size())
		[requestInstanceList: requests, requestInstanceTotal: requests?.size(), patients: patientService.getAll(), doctors: doctorService.getAll(), studies: studyTypeService.getAll(), page: page, siguiente: siguiente?.size(),laboratoryInstanceList: laboratoryService.getAll(), text: textToFind,
			user:authService.getName()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def create() {
		def action = "save"
		def requestInstance = new RequestB(params)
		[requestInstance: requestInstance, patients: patientService.getAll(), doctors: doctorService.getAll(), studies: studyTypeService.getAll(),laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName(), action:action]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def save(Integer id) {

		def requestInstance = new RequestB(params)
		//if(""!=params.get("date")){
		//	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		//	requestInstance.setDate(formatter.parse(params.get("date")));
		//}
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		requestInstance.setDate(formatter.parse(formatter.format(new Date())));
		System.out.println("dateFormated" + formatter.parse(formatter.format(new Date())));
		
		requestInstance.setStudyType(studyTypeService.getById(Integer.parseInt(params.get("studyTypeId"))))
		requestInstance.setDoctor(doctorService.getById(Integer.parseInt(params.get("doctorId"))))
		requestInstance.setPatient(patientService.getById(Integer.parseInt(params.get("patientId"))))
		requestInstance.setStatus(StatusEnum.RECIBIDO)
		def newRequest= requestService.save(requestInstance)
		System.out.println("date" + newRequest.getDate());
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
		[requestInstance: requestInstance, patients: patientService.getAll(), doctors: doctorService.getAll(), studies: studyTypeService.getAll(),laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName()]
	}

	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def update(Integer id) {
		def requestInstance = requestService.getById(Integer.parseInt(params.get("edit")))
		//if(""!=params.get("date")){
		//	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		//	requestInstance.setDate(formatter.parse(params.get("date")));
		//}
		//requestInstance.setDate(new Date((String)params.get("date")));
		requestInstance.setStudyType(studyTypeService.getById(Integer.parseInt(params.get("studyTypeId"))))
		requestInstance.setDoctor(doctorService.getById(Integer.parseInt(params.get("doctorId"))))
		requestInstance.setPatient(patientService.getById(Integer.parseInt(params.get("patientId"))))
		requestInstance.setCode(params.get("code"))
		if (!"".equals(params.get("code_cortes")) && params.containsKey("code_cortes")){
			if (!"".equals(params.get("code_laminas")) && params.containsKey("code_laminas")){
				requestInstance.setCode(params.get("code")+"/"+params.get("code_cortes")+"/"+params.get("code_laminas"))
				requestInstance.setStatus(StatusEnum.PROCESADO)
			}else{
				requestInstance.setCode(params.get("code")+"/"+params.get("code_cortes"))
				requestInstance.setStatus(StatusEnum.PROCESO)
			}
		}else if (requestInstance.getStatus() == StatusEnum.PROCESO && !"".equals(params.get("code_laminas")) && params.containsKey("code_laminas")){
			requestInstance.setCode(params.get("code")+"/"+params.get("code_laminas"))
			requestInstance.setStatus(StatusEnum.PROCESADO)
		}
		requestInstance.setNote(params.get("note"))
		requestInstance.setSpecimen(params.get("specimen"))
		requestService.save(requestInstance)
		redirect(action: "list")
	}
	
	@Secured([
		'ROLE_DOCTOR',
		'ROLE_ADMINISTRADOR',
		'ROLE_SECRETARIA'
	])
	def retire(Integer id){
		def requestInstance = requestService.getById(Integer.parseInt(params.get("id")))
		requestInstance.setStatus(StatusEnum.RETIRADO)
		requestService.save(requestInstance)
		System.out.println(requestInstance.getId() + "id")
		redirect(action: "list")
	}
}