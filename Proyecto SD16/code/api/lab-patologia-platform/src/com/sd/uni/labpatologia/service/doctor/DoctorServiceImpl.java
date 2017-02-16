package com.sd.uni.labpatologia.service.doctor;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.doctor.DoctorDaoImpl;
import com.sd.uni.labpatologia.dao.doctor.IDoctorDao;
import com.sd.uni.labpatologia.domain.doctor.DoctorDomain;
import com.sd.uni.labpatologia.dto.doctor.DoctorDto;
import com.sd.uni.labpatologia.dto.doctor.DoctorResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import com.sd.uni.labpatologia.service.patient.PatientServiceImpl;


@Service
public class DoctorServiceImpl extends BaseServiceImpl<DoctorDto, DoctorDomain, DoctorDaoImpl, DoctorResult> implements IDoctorService{
	@Autowired
	private IDoctorDao _doctorDao;
	
	private static Logger logger = Logger.getLogger(DoctorServiceImpl.class);
	
	@Override
	@Transactional
	//@CacheEvict(value= "lab-patologia-platform-cache",key = "'doctors'")doctorCount
	@CacheEvict(value= "lab-patologia-platform-cache",key = "'doctorCount'")
	@CachePut(value = "lab-patologia-platform-cache", key = "'doctor_' + #dto.id", condition="#dto.id!=null")
	public DoctorDto save(DoctorDto dto) {
		try { 
		    // Lanzo exepcion de tipo runtime para realizar rollback
			final DoctorDomain doctorDomain = convertDtoToDomain(dto);
			final DoctorDomain doctor = _doctorDao.save(doctorDomain);
			final DoctorDto newDto = convertDomainToDto(doctor);
			if (dto.getId() == null) {
				getCacheManager().getCache("lab-patologia-platform-cache").put("doctor_" + doctor.getId(), newDto);
			}
			return newDto;
		} catch(PatologyException ex) { 
			 logger.error(ex);
			 throw new RuntimeException("Error"+DoctorServiceImpl.class+"" + ex.getMessage(), ex); 
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "lab-patologia-platform-cache", key = "'doctor_' + #id")
	public DoctorDto getById(Integer id) throws PatologyException {
		final DoctorDomain doctorDomain = _doctorDao.getById(id);
		final DoctorDto doctorDTO = convertDomainToDto(doctorDomain);
		return doctorDTO;
	}

	@Override
	@Transactional(readOnly = true)
	//@Cacheable(value = "lab-patologia-platform-cache", key = "'doctors'")
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
		doctor.setSpeciality(domain.getSpeciality());
		doctor.setSex(domain.getSex());
		return doctor;
	}

	@Override
	protected DoctorDomain convertDtoToDomain(DoctorDto dto) throws PatologyException{
		final DoctorDomain doctor = new DoctorDomain();
		doctor.setId(dto.getId());
		doctor.setName(dto.getName());
		doctor.setLastName(dto.getLastName());
		doctor.setCi(dto.getCi());
		doctor.setAddress(dto.getAddress());
		doctor.setEmail(dto.getEmail());
		doctor.setPhone(dto.getPhone());
		doctor.setSpeciality(dto.getSpeciality());
		doctor.setSex(dto.getSex());
		return doctor;
	}

	@Override
	@Transactional(readOnly = true)
	public DoctorResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<DoctorDto> doctors = new ArrayList<>();
		for (DoctorDomain domain : _doctorDao.find(textToFind, page, maxItems)) {
			final DoctorDto dto = convertDomainToDto(domain);
			doctors.add(dto);
		}
		final DoctorResult doctorResult = new DoctorResult();
		doctorResult.setDoctors(doctors);
		return doctorResult;
	}
	
	@Cacheable(value = "lab-patologia-platform-cache", key = "'doctorCount'")
	@Transactional(readOnly = true)
	public DoctorResult getCount(){
		final DoctorResult doctorResult = new DoctorResult();
		doctorResult.setCount(_doctorDao.getCount());
		return doctorResult;
	}
	

}