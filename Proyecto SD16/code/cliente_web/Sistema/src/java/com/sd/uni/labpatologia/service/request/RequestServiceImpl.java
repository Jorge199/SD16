package com.sd.uni.labpatologia.service.request;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.request.RequestB;
import com.sd.uni.labpatologia.dto.request.RequestDTO;
import com.sd.uni.labpatologia.dto.request.RequestResult;
import com.sd.uni.labpatologia.rest.request.IRequestResource;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service("requestService")
public class RequestServiceImpl extends BaseServiceImpl<RequestB, RequestDTO>
		implements IRequestService {

	@Autowired
	private IRequestResource _requestResource;
	/*@Autowired
	private IPatientService _patientService;
	@Autowired
	private IStudyTypeService _studyTypeService;
	@Autowired
	private IDoctorService _doctorService;*/

	public RequestServiceImpl() {
	}

	@Override
	public RequestB save(RequestB bean) {
		final RequestDTO client = convertBeanToDto(bean);
		final RequestDTO dto = _requestResource.save(client);
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
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		params.put("date", formato.format(dto.getDate()));
		
		final RequestB requestB = new RequestB(params);
		
		/*requestB.setPatient(_patientService.getById(dto.getPatientId()));
		requestB.setDoctor(_doctorService.getById(dto.getDoctorId()));
		requestB.setStudyType(_studyTypeService.getById(dto.getStudyId()));*/

		return requestB;
	}

	@Override
	protected RequestDTO convertBeanToDto(RequestB bean) {
		final RequestDTO dto = new RequestDTO();
		dto.setId(bean.getId());
		/*dto.setNote(bean.getNote());
		dto.setDate(bean.getDate());*/
		/*dto.setPatientId(bean.getPatient().getId());
		dto.setDoctorId(bean.getDoctor().getId());
		dto.setStudyId(bean.getStudyType().getId());*/
		return dto;
	}
}
