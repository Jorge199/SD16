package com.sd.uni.labpatologia.dao.doctor;

import com.sd.uni.labpatologia.dao.base.IBaseDao;
import com.sd.uni.labpatologia.domain.doctor.DoctorDomain;

import java.util.List;


public interface IDoctorDao extends IBaseDao<DoctorDomain>{
	public int getCount();
}
