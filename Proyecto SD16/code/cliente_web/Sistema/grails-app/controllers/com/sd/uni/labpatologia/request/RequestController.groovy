package com.sd.uni.labpatologia.request

import com.sd.uni.labpatologia.beans.request.RequestB
import com.sd.uni.labpatologia.service.doctor.IDoctorService
import com.sd.uni.labpatologia.service.request.IRequestService
import com.sd.uni.labpatologia.service.study_type.IStudyTypeService
import com.sd.uni.labpatologia.util.StatusEnum;

import java.text.SimpleDateFormat

class RequestController {

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

	//services
	def IRequestService requestService
	def IDoctorService doctorService
	//def IPatientService patientService
	def IStudyTypeService studyTypeService

	def index() {
		redirect(action: "list", params: params)
	}

	def list(Integer max) {
		
		def requests = requestService.getAll()
		System.out.println("Cantidad Solicitudes----------------------------->"+requests.size())
		[requestInstanceList: requests, requestInstanceTotal: requests?.size()]
	
	}

	def create() {
		[requestInstance: new RequestB(params), studies:studyTypeService.getAll()
			,doctors:doctorService.getAll()] //patients:patientService.getAll()
	}

	def save() {
		def requestInstance = new RequestB(params)
		requestInstance.setDoctor(doctorService.getById(Integer.valueOf(params.doctorId)))
		//requestInstance.setPatient(patientService.getById(Integer.valueOf(params.patientId)))
		requestInstance.setStudyType(studyTypeService.getById(Integer.valueOf(params.studyTypeId)))
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		requestInstance.setDate(formatter.parse(formatter.format(new Date())));
		
		def newRequest= requestService.save(requestInstance)
		if (!newRequest?.getId()) {
			render(view: "create", model: [requestInstance: requestInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [
			message(code: 'request.label', default: 'Request'),
			newRequest.getId()
		])
		redirect(action: "show", id: newRequest.getId())
	}

	def show(Long id) {
		def requestInstance = requestService.getById(id.intValue())
		if (!requestInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'request.label', default: 'Request'),
				id
			])
			redirect(action: "list")
			return
		}

		[requestInstance: requestInstance]
	}

	def edit(Long id) {
		def requestInstance = Request.get(id)
		if (!requestInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'request.label', default: 'Request'),
				id
			])
			redirect(action: "list")
			return
		}

		[requestInstance: requestInstance]
	}

	def update(Long id, Long version) {
		def requestInstance = Request.get(id)
		if (!requestInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'request.label', default: 'Request'),
				id
			])
			redirect(action: "list")
			return
		}

		if (version != null) {
			if (requestInstance.version > version) {
				requestInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
						[
							message(code: 'request.label', default: 'Request')] as Object[],
						"Another user has updated this Request while you were editing")
				render(view: "edit", model: [requestInstance: requestInstance])
				return
			}
		}

		requestInstance.properties = params

		if (!requestInstance.save(flush: true)) {
			render(view: "edit", model: [requestInstance: requestInstance])
			return
		}

		flash.message = message(code: 'default.updated.message', args: [
			message(code: 'request.label', default: 'Request'),
			requestInstance.id
		])
		redirect(action: "show", id: requestInstance.id)
	}

	def delete(Long id) {
		def requestInstance = Request.get(id)
		if (!requestInstance) {
			flash.message = message(code: 'default.not.found.message', args: [
				message(code: 'request.label', default: 'Request'),
				id
			])
			redirect(action: "list")
			return
		}

		try {
			requestInstance.delete(flush: true)
			flash.message = message(code: 'default.deleted.message', args: [
				message(code: 'request.label', default: 'Request'),
				id
			])
			redirect(action: "list")
		}
		catch (Exception e) {
			flash.message = message(code: 'default.not.deleted.message', args: [
				message(code: 'request.label', default: 'Request'),
				id
			])
			redirect(action: "show", id: id)
		}
	}
}