package com.sd.uni.labpatologia.service.patient;

import com.sd.uni.labpatologia.beans.patient.PatientB;
import com.sd.uni.labpatologia.dto.patient.PatientDTO;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IPatientService extends IBaseService<PatientB, PatientDTO> {
	public int getCount();
}
