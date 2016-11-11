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
import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.rest.base.IBaseResource;

public interface IDoctorResource extends IBaseResource<DoctorDto> {

	public DoctorResult getAll();
	public DoctorResult find(String textToFind, int maxItems, int page);
}
