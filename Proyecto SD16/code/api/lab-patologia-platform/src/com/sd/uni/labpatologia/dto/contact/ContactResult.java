package com.sd.uni.labpatologia.dto.contact;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;

@XmlRootElement(name = "contactResult")
public class ContactResult extends BaseResult<ContactDto>{
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<ContactDto> getContacts() {
		return getList();
	}

	public void setContacts(List<ContactDto> dtos) {
		super.setList(dtos);
	}

}
