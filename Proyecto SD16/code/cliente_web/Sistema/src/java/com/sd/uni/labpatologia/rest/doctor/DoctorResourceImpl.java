

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.rest.doctor;

/**
 *
 * @author User
 */
import org.springframework.stereotype.Repository;

import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.rest.base.BaseResourceImpl;
import com.sd.uni.labpatologia.rest.doctor.IDoctorResource;
@Repository("doctorResource")
public class DoctorResourceImpl extends BaseResourceImpl<DoctorDto> implements IDoctorResource {

	public DoctorResourceImpl() {
		super(DoctorDto.class, "/doctor");
	}

	@Override
	public DoctorResult getAll() {
		final DoctorResult result = getWebResource().get(DoctorResult.class);
		return result;
	}
        
        @Override
	public DoctorResult find(String textToFind) {
		final DoctorResult result = findWR(textToFind).get(DoctorResult.class);
		return result;
	}

}
