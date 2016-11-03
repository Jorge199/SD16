package com.sd.uni.labpatologia.rest.request;

import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("requestResource")
public class RequestResourceImpl extends BaseResourceImpl<RequestDTO> implements IRequestResource {

	public RequestResourceImpl() {
		super(RequestDTO.class, "/request");
	}

	@Override
	public RequestResult getAll() {
		final RequestResult result = getWebResource().get(RequestResult.class);
		return result;
	}

}
