package com.sd.uni.labpatologia.dto.request;


import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;

@XmlRootElement(name = "requestResult")
public class RequestResult extends BaseResult<RequestDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<RequestDTO> getRequests() {
		return getList();
	}

	public void setRequests(List<RequestDTO> dtos) {
		super.setList(dtos);
	}
}