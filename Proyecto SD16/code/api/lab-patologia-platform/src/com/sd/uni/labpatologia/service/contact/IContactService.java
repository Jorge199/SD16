package com.sd.uni.labpatologia.service.contact;

import com.sd.uni.labpatologia.dao.contact.ContactDaoImpl;
import com.sd.uni.labpatologia.domain.contact.ContactDomain;
import com.sd.uni.labpatologia.dto.contact.ContactDto;
import com.sd.uni.labpatologia.dto.contact.ContactResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IContactService extends IBaseService<ContactDto, ContactDomain, ContactDaoImpl, ContactResult>{
	
}
