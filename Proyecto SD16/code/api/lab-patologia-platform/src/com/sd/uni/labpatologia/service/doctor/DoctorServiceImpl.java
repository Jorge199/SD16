package com.sd.uni.labpatologia.service.doctor;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.doctor.IDoctorDao;
import com.sd.uni.labpatologia.dao.doctor.DoctorDaoImpl;
import com.sd.uni.labpatologia.domain.doctor.DoctorDomain;
import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;


@Service
public class DoctorServiceImpl extends BaseServiceImpl<DoctorDto, DoctorDomain, DoctorDaoImpl, DoctorResult> implements IDoctorService{
	@Autowired
	private IDoctorDao _doctorDao;
	
	@Override
	@Transactional
	public DoctorDto save(DoctorDto dto) {
		final DoctorDomain doctorDomain = convertDtoToDomain(dto);
		final DoctorDomain doctor = _doctorDao.save(doctorDomain);
		return convertDomainToDto(doctor);
	}

	@Override
	@Transactional
	public DoctorDto getById(Integer id) throws PatologyException {
		final DoctorDomain doctorDomain = _doctorDao.getById(id);
		final DoctorDto doctorDTO = convertDomainToDto(doctorDomain);
		return doctorDTO;
	}

	@Override
	@Transactional
	public DoctorResult getAll() {
		final List<DoctorDto> doctors = new ArrayList<>();
		for (DoctorDomain domain : _doctorDao.findAll()) {
			final DoctorDto doctor = convertDomainToDto(domain);
			doctors.add(doctor);
		}

		final DoctorResult doctorResult = new DoctorResult();
		doctorResult.setDoctors(doctors);
		return doctorResult;
	}

	@Override
	protected DoctorDto convertDomainToDto(DoctorDomain domain) {
		final DoctorDto doctor = new DoctorDto();
		doctor.setId(domain.getId());
		doctor.setName(domain.getName());
		doctor.setLastName(domain.getLastName());
		doctor.setCi(domain.getCi());
		doctor.setAddress(domain.getAddress());
		doctor.setEmail(domain.getEmail());
		doctor.setPhone(domain.getPhone());
		return doctor;
	}

	@Override
	protected DoctorDomain convertDtoToDomain(DoctorDto dto) {
		final DoctorDomain doctor = new DoctorDomain();
		doctor.setId(dto.getId());
		doctor.setName(dto.getName());
		doctor.setLastName(dto.getLastName());
		doctor.setCi(dto.getCi());
		doctor.setAddress(dto.getAddress());
		doctor.setEmail(dto.getEmail());
		doctor.setPhone(dto.getPhone());
		return doctor;
	}

	@Override
	@Transactional
	public DoctorResult find(String textToFind) throws PatologyException {
		final List<DoctorDto> doctors = new ArrayList<>();
		for (DoctorDomain domain : _doctorDao.find(textToFind)) {
			final DoctorDto dto = convertDomainToDto(domain);
			doctors.add(dto);
		}
		final DoctorResult doctorResult = new DoctorResult();
		doctorResult.setDoctors(doctors);
		return doctorResult;
	}

	

}