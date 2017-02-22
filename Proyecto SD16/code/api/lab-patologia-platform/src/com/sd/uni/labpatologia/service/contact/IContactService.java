package com.sd.uni.labpatologia.service.contact;

import com.sd.uni.labpatologia.dto.contact.ContactDto;
import com.sd.uni.labpatologia.exception.PatologyException;

public interface IContactService {
	public ContactDto sent(ContactDto contactDto) throws PatologyException;
}
