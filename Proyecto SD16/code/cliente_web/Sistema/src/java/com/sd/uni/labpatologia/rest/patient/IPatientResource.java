package com.sd.uni.labpatologia.rest.patient;

import com.sd.uni.labpatologia.dto.patient.PatientDTO;
import com.sd.uni.labpatologia.dto.patient.PatientResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

public interface IPatientResource extends IBaseResource<PatientDTO> {

	public PatientResult getAll();
	public PatientResult find(String textToFind, int maxItems, int page);
	public int getCount();
}
