package com.sd.uni.labpatologia.service.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.doctor.IDoctorDao;
import com.sd.uni.labpatologia.dao.patient.IPatientDao;
import com.sd.uni.labpatologia.dao.report.IReportDao;
import com.sd.uni.labpatologia.dao.request.IRequestDao;
import com.sd.uni.labpatologia.dao.request.RequestDaoImpl;
import com.sd.uni.labpatologia.dao.study_type.IStudyTypeDao;
import com.sd.uni.labpatologia.dao.user.IUserDao;
import com.sd.uni.labpatologia.domain.request.RequestDomain;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import com.sd.uni.labpatologia.util.StatusEnum;

@Service
public class RequestServiceImpl extends BaseServiceImpl<RequestDTO, RequestDomain, RequestDaoImpl, RequestResult>
		implements IRequestService {
	@Autowired
	private IRequestDao requestDao;
	
	@Autowired
	private IPatientDao patientDao;

	@Autowired
	private IDoctorDao doctorDao;

	@Autowired
	private IStudyTypeDao studyTypeDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private IReportDao reportDao;


	@Override
	@Transactional
	@CachePut(value = "lab-patologia-platform-cache")
	public RequestDTO save(RequestDTO dto) {
		final RequestDomain domain = convertDtoToDomain(dto);
		final RequestDomain requestDomain = requestDao.save(domain);
		return convertDomainToDto(requestDomain);
	}

	@Override
	@Transactional
	@Cacheable(value = "lab-patologia-platform-cache", key = "'request_' + #id")
	public RequestDTO getById(Integer id) throws PatologyException {
		final RequestDomain domain = requestDao.getById(id);
		final RequestDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
	@Cacheable(value = "lab-patologia-platform-cache")
	public RequestResult getAll() {
		final List<RequestDTO> requests = new ArrayList<>();
		for (RequestDomain domain : requestDao.findAll()) {
			final RequestDTO dto = convertDomainToDto(domain);
			requests.add(dto);
		}
		final RequestResult requestResult = new RequestResult();
		requestResult.setRequests(requests);
		return requestResult;
	}

	@Override
	protected RequestDTO convertDomainToDto(RequestDomain domain) {
		final RequestDTO dto = new RequestDTO();
		dto.setId(domain.getId());
		if (null != domain.getNote()) dto.setNote(domain.getNote());
		if (null != domain.getCode()) dto.setCode(domain.getCode());
		if (null != domain.getPatient()) dto.setPatientId(domain.getPatient().getId());
		if (null != domain.getStudyType())dto.setStudyId(domain.getStudyType().getId());
		if (null != domain.getDoctor()) dto.setDoctorId(domain.getDoctor().getId());
		if (null != domain.getDate()) dto.setDate(domain.getDate());
		if (null != domain.getUser()) dto.setUserId(domain.getUser().getId());
		if (null != domain.getStatus()) dto.setStatus(domain.getStatus());
		return dto;
	}

	@Override
	protected RequestDomain convertDtoToDomain(RequestDTO dto) {
		final RequestDomain domain = new RequestDomain();
		domain.setId(dto.getId());
		try {
			if (null != dto.getPatientId()) domain.setPatient(patientDao.getById(dto.getPatientId()));
			if (null != dto.getStudyId()) domain.setStudyType(studyTypeDao.getById(dto.getStudyId()));
			if (null != dto.getDoctorId()) domain.setDoctor(doctorDao.getById(dto.getDoctorId()));
			if (null != dto.getUserId()) domain.setUser(userDao.getById(dto.getUserId()));
		} catch (PatologyException e) {
			e.printStackTrace();
		}
		if (null != dto.getNote()) domain.setNote(dto.getNote());
		if (null != dto.getDate()) domain.setDate(dto.getDate());
		if (null != dto.getCode()) domain.setCode(dto.getCode());
		if (null != dto.getStatus()) domain.setStatus(dto.getStatus());
		return domain;
	}

	@Override
	@Transactional
	public RequestResult find(String textToFind, int page, int maxItems) throws PatologyException {
		final List<RequestDTO> requests = new ArrayList<>();
		for (RequestDomain domain : requestDao.find(textToFind, page, maxItems)) {
			final RequestDTO dto = convertDomainToDto(domain);
			requests.add(dto);
		}
		final RequestResult requestResult = new RequestResult();
		requestResult.setRequests(requests);
		return requestResult;
	}

}

