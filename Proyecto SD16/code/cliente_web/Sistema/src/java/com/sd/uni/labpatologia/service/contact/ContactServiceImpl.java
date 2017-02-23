package com.sd.uni.labpatologia.service.contact;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.contact.ContactB;
import com.sd.uni.labpatologia.dto.contact.ContactDto;
import com.sd.uni.labpatologia.rest.contact.ContactResourceImpl;
import com.sd.uni.labpatologia.rest.contact.IContactResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service("contactService")
public class ContactServiceImpl extends BaseServiceImpl<ContactB, ContactDto> implements IContactService{
	@Autowired
	private IContactResource _contactResource = new ContactResourceImpl();
	
	public ContactServiceImpl() {
		
	}
	
	public ContactB save(ContactB bean) {
		final ContactDto contact = convertBeanToDto(bean);
		final ContactDto dto = _contactResource.save(contact);
		final ContactB contactB = convertDtoToBean(dto);
		return contactB;
	}



	protected ContactB convertDtoToBean(ContactDto dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("userName", String.valueOf(dto.getName()));
		params.put("subject", dto.getSubject());		
        params.put("message", dto.getMessage());
		params.put("email", dto.getEmail());
		params.put("phone", dto.getPhone());
		final ContactB contactB = new ContactB(params);
		return contactB;
	}

	protected ContactDto convertBeanToDto(ContactB bean) {
		final ContactDto dto = new ContactDto();
		dto.setId(bean.getId());
		dto.setName(bean.getUserName());
		dto.setSubject(bean.getSubject());
		dto.setMessage(bean.getMessage());
        dto.setEmail(bean.getEmail());
        dto.setPhone(bean.getPhone());
		return dto;
	}

	@Override
	public List<ContactB> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ContactB> find(String textToFind, int maxItems, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ContactB getById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
