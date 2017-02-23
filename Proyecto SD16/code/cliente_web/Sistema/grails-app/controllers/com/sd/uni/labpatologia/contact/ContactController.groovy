package com.sd.uni.labpatologia.contact

import grails.plugin.springsecurity.annotation.Secured

import org.springframework.beans.factory.annotation.Autowired

import com.sd.uni.labpatologia.beans.contact.ContactB
import com.sd.uni.labpatologia.service.auth.IAuthService
import com.sd.uni.labpatologia.service.contact.IContactService
import com.sd.uni.labpatologia.service.laboratory.ILaboratoryService

class ContactController {
	
	static allowedMethods = [save: "POST"]
	//services
	def IContactService contactService
	def ILaboratoryService laboratoryService
	@Autowired def IAuthService authService
	
	@Secured(['ROLE_ADMINISTRADOR','ROLE_DOCTOR', 'ROLE_SECRETARIA', 'ROLE_TECNICO'])
	def create(){
		[laboratoryInstanceList: laboratoryService.getAll(),
			user:authService.getName(), userName:authService.getName()]
	}
	
	@Secured(['ROLE_ADMINISTRADOR','ROLE_DOCTOR', 'ROLE_SECRETARIA', 'ROLE_TECNICO'])
	def save() {
		def contactInstance = new ContactB(params)
		contactInstance.setUserName(authService.getName());
		def newContact = contactService.save(contactInstance)
		if (!newContact?.getId()) {
			render(view: "create", model: [contactInstance: contactInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'contact.label', default: 'Contact'), newContact.getId()])
		redirect(uri: "/inicio/index")
	}

}
