

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.rest.doctor;

/**
 *
 * @author User
 */
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;
@Repository("doctorResource")
public class DoctorResourceImpl extends BaseResourceImpl<DoctorDto> implements IDoctorResource {

	public DoctorResourceImpl() {
		super(DoctorDto.class, "/doctor");
	}
	@Override
	@CacheEvict(value = CACHE_REGION, key = "'doctor_' + #dto.id", condition = "#dto.id!=null")
	public DoctorDto save(DoctorDto dto) {
		final DoctorDto doctor = getWebResource().entity(dto).post(getDtoClass());
		return doctor;
	}
	
	@Override
	@Cacheable(value = CACHE_REGION, key = "'doctor_' + #id")
	public DoctorDto getById(Integer id) {
		return super.getById(id);
	}
	
	@Override
	@Cacheable(value = CACHE_REGION, key = "'doctors'")
	public DoctorResult getAll() {
		final DoctorResult result = getWebResource().get(DoctorResult.class);
		return result;
	}
        
    @Override
	public DoctorResult find(String textToFind, int maxItems, int page) {
		final DoctorResult result = findWR(textToFind, maxItems, page).get(DoctorResult.class);
		return result;
	}

}
