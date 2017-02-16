package com.sd.uni.labpatologia.service.patient;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.patient.IPatientDao;
import com.sd.uni.labpatologia.dao.patient.PatientDaoImpl;
import com.sd.uni.labpatologia.domain.patient.PatientDomain;
import com.sd.uni.labpatologia.domain.request.RequestDomain;
import com.sd.uni.labpatologia.dto.article.ArticleResult;
import com.sd.uni.labpatologia.dto.patient.PatientDTO;
import com.sd.uni.labpatologia.dto.patient.PatientResult;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import com.sd.uni.labpatologia.service.report.ReportServiceImpl;
import com.sd.uni.labpatologia.service.request.RequestServiceImpl;

@Service
public class PatientServiceImpl extends BaseServiceImpl<PatientDTO, PatientDomain, PatientDaoImpl, PatientResult> implements IPatientService {

	@Autowired
	private IPatientDao patientDao;
	
	private static Logger logger = Logger.getLogger(PatientServiceImpl.class);
	@Override
	@Transactional
	//@CacheEvict(value= "lab-patologia-platform-cache",key = "'patients'")
	@CachePut(value = "lab-patologia-platform-cache", key = "'patient_' + #dto.id", condition="#dto.id!=null")
	public PatientDTO save(PatientDTO dto) {
		try { 
		    // Lanzo exepcion de tipo runtime para realizar rollback
			final PatientDomain patientDomain = convertDtoToDomain(dto);
			final PatientDomain patient = patientDao.save(patientDomain);
			final PatientDTO newDto = convertDomainToDto(patient);
			if (null==dto.getId() ) {
				getCacheManager().getCache("lab-patologia-platform-cache").put("patient_" +newDto.getId(), newDto);
			}
			return newDto;
		} catch(PatologyException ex) { 
			 logger.error(ex);
			 throw new RuntimeException("Error"+PatientServiceImpl.class+"" + ex.getMessage(), ex); 
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "lab-patologia-platform-cache", key = "'patient_' + #id")
	public PatientDTO getById(Integer id)throws PatologyException {
		final PatientDomain patientDomain = patientDao.getById(id);
		final PatientDTO patientDTO = convertDomainToDto(patientDomain);
		return patientDTO;
	}

	@Override
	@Transactional(readOnly = true)
	//@Cacheable(value = "lab-patologia-platform-cache", key = "'patients'")
	public PatientResult getAll() {
		final List<PatientDTO> patients = new ArrayList<>();
		for (PatientDomain domain : patientDao.findAll()) {
			final PatientDTO patient = convertDomainToDto(domain);
			patients.add(patient);
		}

		final PatientResult patientResult = new PatientResult();
		patientResult.setPatients(patients);
		return patientResult;
	}

	@Override
	protected PatientDTO convertDomainToDto(PatientDomain domain) {
		final PatientDTO patient = new PatientDTO();
		patient.setId(domain.getId());
		patient.setName(domain.getName());
		patient.setLastName(domain.getLastName());
		patient.setDocument(domain.getDocument());
		patient.setSex(domain.getSex());
		patient.setBirthDate(domain.getBirthDate());
		patient.setAddress(domain.getAddress());
		patient.setPhone(domain.getPhone());
		patient.setMail(domain.getMail());
		return patient;
	}

	@Override
	protected PatientDomain convertDtoToDomain(PatientDTO dto) throws PatologyException {
		final PatientDomain patient = new PatientDomain();
		patient.setId(dto.getId());
		patient.setName(dto.getName());
		patient.setLastName(dto.getLastName());
		patient.setDocument(dto.getDocument());
		patient.setSex(dto.getSex());
		patient.setBirthDate(dto.getBirthDate());
		patient.setAddress(dto.getAddress());
		patient.setPhone(dto.getPhone());
		patient.setMail(dto.getMail());
		return patient;
	}
	
	@Override
	@Transactional(readOnly = true)
	public PatientResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<PatientDTO> patients = new ArrayList<>();
		for (PatientDomain domain : patientDao.find(textToFind, page, maxItems)) {
			final PatientDTO dto = convertDomainToDto(domain);
			patients.add(dto);
		}
		final PatientResult patResult = new PatientResult();
		patResult.setPatients(patients);
		return patResult;
	}
	@Transactional(readOnly = true)
	public PatientResult getCount(){
		final PatientResult patientResult = new PatientResult();
		patientResult.setCount(patientDao.getCount());
		return patientResult;
	}

}
