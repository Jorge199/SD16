package com.sd.uni.labpatologia.service.doctor;

import com.sd.uni.labpatologia.dao.doctor.DoctorDaoImpl;
import com.sd.uni.labpatologia.domain.doctor.DoctorDomain;
import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.service.base.IBaseService;

public interface IDoctorService extends IBaseService<DoctorDto, DoctorDomain, DoctorDaoImpl, DoctorResult>{
	public DoctorResult getCount();
}