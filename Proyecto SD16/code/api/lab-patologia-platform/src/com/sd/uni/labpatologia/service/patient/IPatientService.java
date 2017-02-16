package com.sd.uni.labpatologia.service.patient;

import com.sd.uni.labpatologia.dao.patient.PatientDaoImpl;
import com.sd.uni.labpatologia.domain.patient.PatientDomain;
import com.sd.uni.labpatologia.dto.patient.PatientDTO;
import com.sd.uni.labpatologia.dto.patient.PatientResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IPatientService extends IBaseService<PatientDTO, PatientDomain, PatientDaoImpl, PatientResult> {
	public PatientResult getCount();
}
