package com.sd.uni.labpatologia.service.request;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.doctor.DoctorB;
import com.sd.uni.labpatologia.beans.report.ReportB;
import com.sd.uni.labpatologia.beans.request.RequestB;
import com.sd.uni.labpatologia.dto.report.ReportDTO;
import com.sd.uni.labpatologia.dto.report.ReportResult;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;
import com.sd.uni.labpatologia.rest.request.IRequestResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;
import com.sd.uni.labpatologia.service.doctor.IDoctorService;
import com.sd.uni.labpatologia.service.patient.IPatientService;
import com.sd.uni.labpatologia.service.study_type.IStudyTypeService;
import com.sd.uni.labpatologia.service.user.IUserService;

@Service("requestService")
public class RequestServiceImpl extends BaseServiceImpl<RequestB, RequestDTO>
		implements IRequestService {

	@Autowired
	private IRequestResource _requestResource;
	@Autowired
	private IPatientService _patientService;
	@Autowired
	private IStudyTypeService _studyTypeService;
	@Autowired
	private IDoctorService _doctorService;
	@Autowired
	private IUserService _userService;

	public RequestServiceImpl() {
	}

	@Override
	public RequestB save(RequestB bean) {
		final RequestDTO request = convertBeanToDto(bean);
		final RequestDTO dto = _requestResource.save(request);
		final RequestB requestB = convertDtoToBean(dto);
		return requestB;
	}

	@Override
	public List<RequestB> getAll() {
		final RequestResult result = _requestResource.getAll();
		final List<RequestDTO> rList = null == result.getRequests() ? new ArrayList<RequestDTO>()
				: result.getRequests();

		final List<RequestB> requests = new ArrayList<RequestB>();
		for (RequestDTO dto : rList) {
			final RequestB bean = convertDtoToBean(dto);
			requests.add(bean);
		}
		return requests;
	}

	@Override
	public RequestB getById(Integer id) {
		final RequestDTO dto = _requestResource.getById(id);
		final RequestB bean = convertDtoToBean(dto);
		return bean;
	}

	@Override
	protected RequestB convertDtoToBean(RequestDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("note", dto.getNote());
		params.put("code", dto.getCode());
		final RequestB requestB = new RequestB(params);
		requestB.setDate(dto.getDate());
		requestB.setStatus(dto.getStatus());
		requestB.setPatient(_patientService.getById(dto.getPatientId()));
		requestB.setDoctor(_doctorService.getById(dto.getDoctorId()));
		requestB.setStudyType(_studyTypeService.getById(dto.getStudyId()));
		requestB.setUser(_userService.getById(dto.getUserId()));
		return requestB;
	}

	@Override
	protected RequestDTO convertBeanToDto(RequestB bean) {
		final RequestDTO dto = new RequestDTO();
		dto.setId(bean.getId());
		dto.setNote(bean.getNote());
		dto.setDate(bean.getDate());
		dto.setCode(bean.getCode());
		dto.setStatus(bean.getStatus());
		dto.setPatientId(bean.getPatient().getId());
		dto.setDoctorId(bean.getDoctor().getId());
		dto.setStudyId(bean.getStudyType().getId());
		dto.setUserId(bean.getUser().getId());
		return dto;
	}

	@Override
	public List<RequestB> find(String textToFind) {
		final RequestResult result = _requestResource.find(textToFind);
		final List<RequestDTO> rList = null == result.getRequests() ? new ArrayList<RequestDTO>()
				: result.getRequests();

		final List<RequestB> requests = new ArrayList<RequestB>();
		for (RequestDTO dto : rList) {
			final RequestB bean = convertDtoToBean(dto);
			requests.add(bean);
		}
		return requests;
	}
	
}
