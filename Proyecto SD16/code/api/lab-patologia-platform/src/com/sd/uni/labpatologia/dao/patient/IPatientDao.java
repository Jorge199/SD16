package com.sd.uni.labpatologia.dao.patient;

import com.sd.uni.labpatologia.dao.base.IBaseDao;
import com.sd.uni.labpatologia.domain.patient.PatientDomain;

public interface IPatientDao extends IBaseDao<PatientDomain> {
	public int getCount();
}
