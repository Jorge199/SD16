package com.sd.uni.labpatologia.service.patient;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.patient.IPatientDao;
import com.sd.uni.labpatologia.dao.patient.PatientDaoImpl;
import com.sd.uni.labpatologia.domain.patient.PatientDomain;
import com.sd.uni.labpatologia.dto.patient.PatientDTO;
import com.sd.uni.labpatologia.dto.patient.PatientResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class PatientServiceImpl extends BaseServiceImpl<PatientDTO, PatientDomain, PatientDaoImpl, PatientResult> implements IPatientService {

	@Autowired
	private IPatientDao patientDao;
	
	@Override
	@Transactional
	@CachePut(value = "lab-patologia-platform-cache", key = "'report_dto' + #id")
	public PatientDTO save(PatientDTO dto) {
		final PatientDomain patientDomain = convertDtoToDomain(dto);
		final PatientDomain patient = patientDao.save(patientDomain);
		return convertDomainToDto(patient);
	}

	@Override
	@Transactional
	@Cacheable(value = "lab-patologia-platform-cache", key = "'patient_' + #id")
	public PatientDTO getById(Integer id)throws PatologyException {
		final PatientDomain patientDomain = patientDao.getById(id);
		final PatientDTO patientDTO = convertDomainToDto(patientDomain);
		return patientDTO;
	}

	@Override
	@Transactional
	@Cacheable(value = "lab-patologia-platform-cache")
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
		return patient;
	}

	@Override
	protected PatientDomain convertDtoToDomain(PatientDTO dto) {
		final PatientDomain patient = new PatientDomain();
		patient.setId(dto.getId());
		patient.setName(dto.getName());
		patient.setLastName(dto.getLastName());
		patient.setDocument(dto.getDocument());
		patient.setSex(dto.getSex());
		patient.setBirthDate(dto.getBirthDate());
		patient.setAddress(dto.getAddress());
		patient.setPhone(dto.getPhone());
		return patient;
	}
	
	@Override
	@Transactional
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

}
