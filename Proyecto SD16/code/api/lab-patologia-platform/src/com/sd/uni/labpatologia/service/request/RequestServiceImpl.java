package com.sd.uni.labpatologia.service.request;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.request.IRequestDao;
import com.sd.uni.labpatologia.dao.request.RequestDaoImpl;
import com.sd.uni.labpatologia.domain.request.RequestDomain;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service
public class RequestServiceImpl extends BaseServiceImpl<RequestDTO, RequestDomain, RequestDaoImpl, RequestResult>
		implements IRequestService {
	@Autowired
	private IRequestDao requestDao;

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
		dto.setPatientId(domain.getPatientId());
		dto.setStudyId(domain.getStudyId());
		dto.setDoctorId(domain.getDoctorId());
		dto.setNote(domain.getNote());
		dto.setDate(domain.getDate());
		return dto;
	}

	@Override
	protected RequestDomain convertDtoToDomain(RequestDTO dto) {
		final RequestDomain domain = new RequestDomain();
		domain.setId(dto.getId());
		domain.setPatientId(dto.getPatientId());
		domain.setStudyId(dto.getStudyId());
		domain.setDoctorId(dto.getDoctorId());
		domain.setNote(dto.getNote());
		domain.setDate(dto.getDate());
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

