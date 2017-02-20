package com.sd.uni.labpatologia.rest.request;

import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

public interface IRequestResource extends IBaseResource<RequestDTO> {

	public RequestResult getAll();
	public RequestResult find(String textToFind, int maxItems, int page);
	public int getCount();
}
