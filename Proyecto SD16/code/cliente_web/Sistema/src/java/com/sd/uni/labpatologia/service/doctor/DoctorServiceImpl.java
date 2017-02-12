/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.service.doctor;

/**
 *
 * @author Jorge Esquivel
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.doctor.DoctorB;
import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.rest.doctor.IDoctorResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service("doctorService")
public class DoctorServiceImpl extends BaseServiceImpl<DoctorB, DoctorDto>
implements IDoctorService {

	@Autowired
	private IDoctorResource _doctorResource;

	public DoctorServiceImpl() {
	}

	@Override
	public DoctorB save(DoctorB bean) {
		final DoctorDto doctor = convertBeanToDto(bean);
		final DoctorDto dto = _doctorResource.save(doctor);
		final DoctorB doctorB = convertDtoToBean(dto);
		return doctorB;
	}

	@Override
	public List<DoctorB> getAll() {
		final DoctorResult result = _doctorResource.getAll();
		final List<DoctorDto> rList = null == result.getDoctors() ? new ArrayList<DoctorDto>()
				: result.getDoctors();

		final List<DoctorB> doctors = new ArrayList<DoctorB>();
		for (DoctorDto dto : rList) {
			final DoctorB bean = convertDtoToBean(dto);
			doctors.add(bean);
		}
		return doctors;
	}

	@Override
	public DoctorB getById(Integer id) {
		final DoctorDto dto = _doctorResource.getById(id);
		final DoctorB bean = convertDtoToBean(dto);
		return bean;
	}

	@Override
	protected DoctorB convertDtoToBean(DoctorDto dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		params.put("last_name", dto.getLastName());
		params.put("ci", dto.getCi());
		params.put("address", dto.getAddress());
		params.put("phone", dto.getPhone());
		params.put("email", dto.getEmail());
		params.put("speciality", dto.getSpeciality());

		final DoctorB doctorB = new DoctorB(params);
		doctorB.setSex(dto.getSex());
		return doctorB;
	}

	@Override
	protected DoctorDto convertBeanToDto(DoctorB bean) {
		final DoctorDto dto = new DoctorDto();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setLastName(bean.getLastName());
		dto.setCi(bean.getCi());
		dto.setAddress(bean.getAddress());
		dto.setPhone(bean.getPhone());
		dto.setEmail(bean.getEmail());
		dto.setSpeciality(bean.getSpeciality());
		dto.setSex(bean.getSex());
		return dto;
	}

	@Override
	public List<DoctorB> find(String textToFind, int maxItems, int page) {
		final DoctorResult result = _doctorResource.find(textToFind, maxItems, page);
		final List<DoctorDto> rList = null == result.getDoctors() ? new ArrayList<DoctorDto>()
				: result.getDoctors();

		final List<DoctorB> doctors = new ArrayList<DoctorB>();
		for (DoctorDto dto : rList) {
			final DoctorB bean = convertDtoToBean(dto);
			doctors.add(bean);
		}
		return doctors;
	}
}
