package com.sd.uni.labpatologia.service.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public RequestDTO save(RequestDTO dto) {
		final RequestDomain domain = convertDtoToDomain(dto);
		final RequestDomain requestDomain = requestDao.save(domain);
		return convertDomainToDto(requestDomain);
	}

	@Override
	@Transactional
	public RequestDTO getById(Integer id) throws PatologyException {
		final RequestDomain domain = requestDao.getById(id);
		final RequestDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional
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
		dto.setPatientId(domain.getPatient().getId());
		dto.setStudyId(domain.getStudyType().getId());
		dto.setDoctorId(domain.getDoctor().getId());
		dto.setNote(domain.getNote());
		dto.setDate(domain.getDate());
		dto.setUserId(domain.getUser().getId());
		dto.setCode(domain.getCode());
		dto.setStatus(domain.getStatus().toString());
		return dto;
	}

	@Override
	protected RequestDomain convertDtoToDomain(RequestDTO dto) {
		final RequestDomain domain = new RequestDomain();
		domain.setId(dto.getId());
		try {
			domain.setPatient(patientDao.getById(dto.getPatientId()));
			domain.setStudyType(studyTypeDao.getById(dto.getStudyId()));
			domain.setDoctor(doctorDao.getById(dto.getDoctorId()));
			domain.setUser(userDao.getById(dto.getUserId()));
		} catch (PatologyException e) {
			e.printStackTrace();
		}
		domain.setNote(dto.getNote());
		domain.setDate(dto.getDate());
		domain.setCode(dto.getCode());
		domain.setStatus(StatusEnum.valueOf(dto.getStatus()));
		return domain;
	}

	@Override
	@Transactional
	public RequestResult find(String textToFind) throws PatologyException {
		final List<RequestDTO> requests = new ArrayList<>();
		for (RequestDomain domain : requestDao.find(textToFind)) {
			final RequestDTO dto = convertDomainToDto(domain);
			requests.add(dto);
		}
		final RequestResult requestResult = new RequestResult();
		requestResult.setRequests(requests);
		return requestResult;
	}

}

