package com.sd.uni.labpatologia.rest.doctor;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("doctorResource")
public class DoctorResourceImpl extends BaseResourceImpl<DoctorDto> implements
		IDoctorResource {

	public DoctorResourceImpl() {
		super(DoctorDto.class, "/doctor");
	}

	@Override
	@CacheEvict(value = CACHE_REGION, key = "'doctors'")
	@CachePut(value = CACHE_REGION, key = "'doctor_' + #doctor.id", condition = "#doctor.id!=null")
	public DoctorDto save(DoctorDto doctor) {
		DoctorDto newDto = super.save(doctor);
		if (null == doctor.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"doctor_" + newDto.getId(), newDto);
		}
		return newDto;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'doctor_' + #id")
	public DoctorDto getById(Integer id) {
		return super.getById(id);
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'doctors'")
	public DoctorResult getAll() {
		setWebResourceBasicAuthFilter();
		final DoctorResult result = getWebResource().get(DoctorResult.class);
		return result;
	}

	@Override
	public DoctorResult find(String textToFind, int maxItems, int page) {
		setWebResourceBasicAuthFilter();
		final DoctorResult result = findWR(textToFind, maxItems, page).get(
				DoctorResult.class);
		return result;
	}

}
