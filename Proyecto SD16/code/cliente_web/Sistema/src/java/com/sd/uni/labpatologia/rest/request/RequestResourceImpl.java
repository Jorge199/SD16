package com.sd.uni.labpatologia.rest.request;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.patient.PatientResult;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("requestResource")
public class RequestResourceImpl extends BaseResourceImpl<RequestDTO> implements
		IRequestResource {

	public RequestResourceImpl() {
		super(RequestDTO.class, "/request");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'requests'")
	@CachePut(value = CACHE_REGION, key = "'request_' + #request.id", condition = "#request.id!=null")
	public RequestDTO save(RequestDTO request) {
		RequestDTO newDto = super.save(request);
		if (request.getId() == null) {
			getCacheManager().getCache(CACHE_REGION).put(
					"request_" + newDto.getId(), newDto);
		}
		return newDto;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'request_' + #id")
	public RequestDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'requests'")
	public RequestResult getAll() {
		setWebResourceBasicAuthFilter();
		final RequestResult result = getWebResource().get(RequestResult.class);
		return result;
	}
	
	public int getCount(){
		setWebResourceBasicAuthFilter();
		final RequestResult countResult = getCountResult().get(RequestResult.class);
		return countResult.getCount();
	}

	@Override
	public RequestResult find(String textToFind, int maxItems, int page) {
		setWebResourceBasicAuthFilter();
		final RequestResult result = findWR(textToFind, maxItems, page).get(
				RequestResult.class);
		return result;
	}

}
