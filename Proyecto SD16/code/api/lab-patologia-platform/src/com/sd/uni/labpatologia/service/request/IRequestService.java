package com.sd.uni.labpatologia.service.request;

import com.sd.uni.labpatologia.dao.request.RequestDaoImpl;
import com.sd.uni.labpatologia.domain.request.RequestDomain;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IRequestService extends IBaseService<RequestDTO, RequestDomain, RequestDaoImpl, RequestResult> {
	public RequestResult find(String textToFind) throws PatologyException;
}