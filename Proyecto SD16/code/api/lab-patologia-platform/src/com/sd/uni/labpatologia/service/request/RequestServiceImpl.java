package com.sd.uni.labpatologia.service.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.doctor.IDoctorDao;
import com.sd.uni.labpatologia.dao.message.IMessageDao;
import com.sd.uni.labpatologia.dao.patient.IPatientDao;
import com.sd.uni.labpatologia.dao.report.IReportDao;
import com.sd.uni.labpatologia.dao.request.IRequestDao;
import com.sd.uni.labpatologia.dao.request.RequestDaoImpl;
import com.sd.uni.labpatologia.dao.study_type.IStudyTypeDao;
import com.sd.uni.labpatologia.dao.user.IUserDao;
import com.sd.uni.labpatologia.domain.message.MessageDomain;
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
	
	@Autowired
	private IMessageDao messageDao;

	private static Logger logger = Logger.getLogger(RequestServiceImpl.class);
	
	@Override
	@Transactional
	//@CacheEvict(value= "lab-patologia-platform-cache",key = "'requests'")
	@CachePut(value = "lab-patologia-platform-cache", key = "'request_' + #dto.id", condition="#dto.id!=null")
	public RequestDTO save(RequestDTO dto) {
		try { 
		    // Lanzo exepcion de tipo runtime para realizar rollback
			final RequestDomain domain = convertDtoToDomain(dto);
			final RequestDomain request = requestDao.save(domain);
			final RequestDTO newDto = convertDomainToDto(request);
			if (dto.getId() == null) {
				getCacheManager().getCache("lab-patologia-platform-cache").put("request_" + request.getId(), newDto);
			}
			return newDto;
		} catch(PatologyException ex) { 
			 logger.error(ex);
			 throw new RuntimeException("Error"+RequestServiceImpl.class+"" + ex.getMessage(), ex); 
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	@Cacheable(value = "lab-patologia-platform-cache", key = "'request_' + #id")
	public RequestDTO getById(Integer id) throws PatologyException {
		final RequestDomain domain = requestDao.getById(id);
		final RequestDTO dto = convertDomainToDto(domain);
		return dto;
	}

	@Override
	@Transactional(readOnly = true)
	//@Cacheable(value = "lab-patologia-platform-cache", key = "'requests'")
	public RequestResult getAll(){
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
	protected RequestDTO convertDomainToDto(RequestDomain domain){
		final RequestDTO dto = new RequestDTO();
		dto.setId(domain.getId());
		dto.setNote(domain.getNote());
		dto.setCode(domain.getCode());
		dto.setPatientId(domain.getPatient().getId());
		dto.setStudyId(domain.getStudyType().getId());
		dto.setDoctorId(domain.getDoctor().getId());
		dto.setDate(domain.getDate());
		//dto.setUserId(domain.getUser().getId());
		dto.setStatus(domain.getStatus());
		return dto;
	}

	@Override
	protected RequestDomain convertDtoToDomain(RequestDTO dto) throws PatologyException{
		final RequestDomain domain = new RequestDomain();
		domain.setId(dto.getId());
		domain.setPatient(patientDao.getById(dto.getPatientId()));
		domain.setStudyType(studyTypeDao.getById(dto.getStudyId()));
	    domain.setDoctor(doctorDao.getById(dto.getDoctorId()));
		//domain.setUser(userDao.getById(dto.getUserId()));
		
		domain.setNote(dto.getNote());
		domain.setDate(dto.getDate());
		domain.setCode(dto.getCode());
		domain.setStatus(dto.getStatus());
		
		// Si el estado es TERMINADO le agraga a la tabla de pendientes para notificacion
		if (dto.getStatus() == StatusEnum.TERMINADO){
			String mail = patientDao.getById(dto.getPatientId()).getMail();
			if (!"".equals(mail)){
				System.out.println("pidiendo notificacion para: "+ mail);
				final MessageDomain messageDomain = new MessageDomain();
				messageDomain.setId(dto.getId());
				messageDomain.setCreationDate(new Date());
				messageDomain.setEmail(mail);
				messageDao.save(messageDomain);
			}
		}
		return domain;
	}

	@Override
	@Transactional(readOnly = true)
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

