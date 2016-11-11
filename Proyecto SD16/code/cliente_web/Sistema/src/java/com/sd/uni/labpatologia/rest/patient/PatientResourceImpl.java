package com.sd.uni.labpatologia.rest.patient;

import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.patient.PatientDTO;
import com.sd.uni.labpatologia.dto.patient.PatientResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;

@Repository("patientResource")
public class PatientResourceImpl extends BaseResourceImpl<PatientDTO> implements IPatientResource {

	public PatientResourceImpl() {
		super(PatientDTO.class, "/patient");
	}

	@Override
	public PatientResult getAll() {
		final PatientResult result = getWebResource().get(PatientResult.class);
		return result;
	}
	
	@Override
	public PatientResult find(String textToFind, int maxItems, int page) {
		final PatientResult result = findWR(textToFind, maxItems, page).get(PatientResult.class);
		return result;
	}

}
