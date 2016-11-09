package com.sd.uni.labpatologia.patient
import com.sd.uni.labpatologia.beans.patient.PatientB
import com.sd.uni.labpatologia.service.patient.*

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
			def patients = patientService.getAll()
			[patientInstanceList: patients, patientInstanceTotal: patients?.size()]
		}
	
		def save() {
			def patientInstance = new PatientB(params)
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
			patientInstance.setBirthDate(formatter.parse(formatter.format(new Date())));
			def newPatient = patientService.save(patientInstance)
			if (!newPatient?.getId()) {
				render(view: "create", model: [patientInstance: patientInstance])
				return
			}
	
			flash.message = message(code: 'default.created.message', args: [
				message(code: 'patient.label', default: 'Patient'),
				newPatient.getId()])
			redirect(action: "show", id: newPatient.getId())
		}
		def show(Long id) {
			def patientInstance = patientService.getById(id.intValue())
			if (!patientInstance) {
				flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'patient.label', default: 'Patient'),
					id
				])
			}
			[patientInstance: patientInstance]
		}
	
		def edit(Long id) {
			def patientInstance = patientService.getById(id.intValue())
			if (!patientInstance) {
				flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'patient.label', default: 'Patient'),
					id
				])
				redirect(action: "list")
				return
			}
	
			[patientInstance: patientInstance]
		}
	
		def update(Long id, Long version) {
			def patientInstance = patientService.getById(id.intValue())
			if (!patientInstance) {
				flash.message = message(code: 'default.not.found.message', args: [
					message(code: 'patient.label', default: 'Patient'),
					id
				])
				redirect(action: "list")
				return
			}
	
			if (version != null) {
				if (patientInstance.version > version) {
					patientInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
							[
								message(code: 'patient.label', default: 'Patient')] as Object[],
							"Another user has updated this Client while you were editing")
					render(view: "edit", model: [patientInstance: patientInstance])
					return
				}
			}
	
			patientInstance.properties = params
	
			if (!patientInstance.save(flush: true)) {
				render(view: "edit", model: [patientInstance: patientInstance])
				return
			}
	
			flash.message = message(code: 'default.updated.message', args: [
				message(code: 'patient.label', default: 'Patient'),
				patientInstance.id
			])
			redirect(action: "show", id: patientInstance.id)
		}
	
		
	
	}
	
