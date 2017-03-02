package com.sd.uni.labpatologia.rest.contact;

import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.contact.ContactDto;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("contactResource")
public class ContactResourceImpl extends BaseResourceImpl<ContactDto> implements IContactResource {

	public ContactResourceImpl() {
		super(ContactDto.class, "/contact");
	}

	@Override
	public ContactDto save(ContactDto contact) {
		ContactDto newDto = getWebResource().entity(contact).post(contact.getClass());
		return newDto;
	}

	@Override
	public ContactDto getById(Integer id) {
		return null;
	}

}
