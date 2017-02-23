package com.sd.uni.labpatologia.resource;


import javax.ws.rs.POST;
import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Component;

import com.sd.uni.labpatologia.dto.contact.ContactDto;
import com.sd.uni.labpatologia.service.contact.IContactService;


@Path("/contact")
@Component
public class ContactResource {

	@Autowired
	private IContactService _contactService;
	
	@POST
	@Secured({"ROLE_ADMINISTRADOR","ROLE_DOCTOR"})
	public ContactDto save(ContactDto contact) {
		return _contactService.save(contact);
	}
}
