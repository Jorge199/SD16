package com.sd.uni.labpatologia.request

import com.sd.uni.labpatologia.beans.request.RequestB
import com.sd.uni.labpatologia.service.doctor.DoctorServiceImpl
import com.sd.uni.labpatologia.service.doctor.IDoctorService
import com.sd.uni.labpatologia.service.patient.IPatientService
import com.sd.uni.labpatologia.service.patient.PatientServiceImpl
import com.sd.uni.labpatologia.service.request.IRequestService
import com.sd.uni.labpatologia.service.study_type.IStudyTypeService
import com.sd.uni.labpatologia.service.study_type.StudyTypeServiceImpl
import com.sd.uni.labpatologia.service.user.IUserService
import com.sd.uni.labpatologia.util.StatusEnum;

import java.text.SimpleDateFormat

class RequestController {

	static allowedMethods = [save: "POST", update: "POST"]

	//services
	def IRequestService requestService
	def IDoctorService doctorService
	def IPatientService patientService
	def IStudyTypeService studyTypeService
	def IUserService userService

	def index() {
		redirect(action: "list")
	}

	def list() {
		def requests = requestService.getAll()
		System.out.println("Cantidad Solicitudes----------------------------->"+requests.size())
		[requestInstanceList: requests, requestInstanceTotal: requests?.size()]
	
	}

	def create() {
		def requestInstance = new RequestB(params)
		[requestInstance: requestInstance, patients: patientService.getAll(), doctors: doctorService.getAll(), studies: studyTypeService.getAll()]
	}

	def save() {
		
		def requestInstance = new RequestB(params)
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		requestInstance.setDate(formatter.parse(formatter.format(new Date())));
		requestInstance.setStudyType(studyTypeService.getById(Integer.parseInt(params.get("studyTypeId"))))
		requestInstance.setDoctor(doctorService.getById(Integer.parseInt(params.get("doctorId"))))
		requestInstance.setPatient(patientService.getById(Integer.parseInt(params.get("patientId"))))
		
		def newRequest= requestService.save(requestInstance)
		if (!newRequest?.getId()) {
			//redirect(action: "list", id: newReport.getId())
			//return
		}
		redirect(action: "list", id: newRequest.getId())
	}

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
		[requestInstance: requestInstance, patients: patientService.getAll(), doctors: doctorService.getAll(), studies: studyTypeService.getAll()]
	}
	
	def update(Integer id) {
		def requestInstance = new RequestB(params)
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		requestInstance.setDate(formatter.parse(formatter.format(new Date())));
		requestInstance.setStudyType(studyTypeService.getById(Integer.parseInt(params.get("studyTypeId"))))
		requestInstance.setDoctor(doctorService.getById(Integer.parseInt(params.get("doctorId"))))
		requestInstance.setPatient(patientService.getById(Integer.parseInt(params.get("patientId"))))
		requestInstance.setId(Integer.parseInt(params.get("edit")))
		requestInstance.setStatus(StatusEnum.valueOf(params.get("status")))
		requestInstance.save(requestInstance)
		redirect(action: "list")
	}
}