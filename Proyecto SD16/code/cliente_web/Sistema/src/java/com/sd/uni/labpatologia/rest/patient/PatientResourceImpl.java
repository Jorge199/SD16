package com.sd.uni.labpatologia.rest.patient;

import org.springframework.cache.annotation.CacheEvict;
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
	@CacheEvict(value = CACHE_REGION, key = "'patient_' + #dto.id", condition = "#dto.id!=null")
	public PatientDTO save(PatientDTO dto) {
		final PatientDTO patient = getWebResource().entity(dto).post(
				getDtoClass());
		return patient;
	}

	@Cacheable(value = CACHE_REGION, key = "'patient_' + #id")
	@Override
	public PatientDTO getById(Integer id) {
		return super.getById(id);
	}

	@Cacheable(value = CACHE_REGION, key = "'patients'")
	@Override
	public PatientResult getAll() {
		final PatientResult result = getWebResource().get(PatientResult.class);
		return result;
	}

	@Override
	public PatientResult find(String textToFind, int maxItems, int page) {
		final PatientResult result = findWR(textToFind, maxItems, page).get(
				PatientResult.class);
		return result;
	}

}
