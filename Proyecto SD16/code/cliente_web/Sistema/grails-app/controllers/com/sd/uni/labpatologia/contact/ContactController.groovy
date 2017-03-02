package com.sd.uni.labpatologia.contact

import grails.plugin.springsecurity.annotation.Secured

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.authentication.AnonymousAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder

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
	
	def create(){
		def name = "Anónimo"
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			name = authService.getName();
		}
		
		[laboratoryInstanceList: laboratoryService.getAll(),
			user:name, userName:name]
	}
	
	
	def save() {
		def contactInstance = new ContactB(params)
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (!(authentication instanceof AnonymousAuthenticationToken)) {
			contactInstance.setUserName(authService.getName());
		}else{
			contactInstance.setUserName("Anónimo");
		}
		def newContact = contactService.save(contactInstance)
		if (!newContact?.getId()) {
			render(view: "create", model: [contactInstance: contactInstance])
			return
		}

		flash.message = message(code: 'default.created.message', args: [message(code: 'contact.label', default: 'Contact'), newContact.getId()])
		redirect(uri: "/inicio/index")
	}

}
