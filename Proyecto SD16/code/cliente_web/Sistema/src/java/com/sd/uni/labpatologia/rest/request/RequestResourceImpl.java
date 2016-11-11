package com.sd.uni.labpatologia.rest.request;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("requestResource")
public class RequestResourceImpl extends BaseResourceImpl<RequestDTO> implements IRequestResource {

	public RequestResourceImpl() {
		super(RequestDTO.class, "/request");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'request_' + #dto.id", condition = "#dto.id!=null")
	public RequestDTO save(RequestDTO dto) {
		final RequestDTO request = getWebResource().entity(dto).post(getDtoClass());
		return request;
	}
	
	@Cacheable(value = CACHE_REGION, key = "'request_' + #id")
	@Override
	public RequestDTO getById(Integer id) {
		return super.getById(id);
	}
	
	@Cacheable(value = CACHE_REGION, key = "'requests'")
	@Override
	public RequestResult getAll() {
		final RequestResult result = getWebResource().get(RequestResult.class);
		return result;
	}
	
	@Override
	public RequestResult find(String textToFind, int maxItems, int page) {
		final RequestResult result = findWR(textToFind, maxItems, page).get(RequestResult.class);
		return result;
	}

}
