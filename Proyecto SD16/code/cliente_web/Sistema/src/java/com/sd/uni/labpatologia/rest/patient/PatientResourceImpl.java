package com.sd.uni.labpatologia.rest.patient;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.patient.PatientDTO;
import com.sd.uni.labpatologia.dto.patient.PatientResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("patientResource")
public class PatientResourceImpl extends BaseResourceImpl<PatientDTO> implements
		IPatientResource {

	public PatientResourceImpl() {
		super(PatientDTO.class, "/patient");
	}

	@Override
	//@CacheEvict(value = CACHE_REGION, key = "'patients'")
	@CachePut(value = CACHE_REGION, key = "'patient_' + #patient.id", condition = "#patient.id!=null")
	public PatientDTO save(PatientDTO patient) {
		PatientDTO newDto = super.save(patient);
		if (null == patient.getId()) {
			getCacheManager().getCache(CACHE_REGION).put(
					"patient_" + patient.getId(), newDto);
		}
		return newDto;
	}

	@Override
	@Cacheable(value = CACHE_REGION, key = "'patient_' + #id")
	public PatientDTO getById(Integer id) {
		return super.getById(id);
	}

	@Override
	//@Cacheable(value = CACHE_REGION, key = "'patients'")
	public PatientResult getAll() {
		setWebResourceBasicAuthFilter();
		final PatientResult result = getWebResource().get(PatientResult.class);
		return result;
	}

	@Override
	public PatientResult find(String textToFind, int maxItems, int page) {
		setWebResourceBasicAuthFilter();
		final PatientResult result = findWR(textToFind, maxItems, page).get(
				PatientResult.class);
		return result;
	}

}
