
package com.sd.uni.labpatologia.service.patient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.beans.patient.PatientB;
import com.sd.uni.labpatologia.dto.patient.PatientDTO;
import com.sd.uni.labpatologia.dto.patient.PatientResult;
import com.sd.uni.labpatologia.rest.patient.IPatientResource;
import com.sd.uni.labpatologia.rest.patient.PatientResourceImpl;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;

@Service("patientService")
public class PatientServiceImpl extends BaseServiceImpl<PatientB, PatientDTO>implements IPatientService {

	@Autowired
	private IPatientResource _patientResource=new PatientResourceImpl();
	
	public PatientServiceImpl() {	
	}

	@Override
	public PatientB save(PatientB bean) {
		final PatientDTO patient = convertBeanToDto(bean);
		final PatientDTO dto = _patientResource.save(patient);
		final PatientB patientB = convertDtoToBean(dto);
		return patientB;
	}

	@Override
	public List<PatientB> getAll() {
		final PatientResult result = _patientResource.getAll();
		final List<PatientDTO> rList = null == result.getPatients() ? new ArrayList<PatientDTO>()
				: result.getPatients();

		final List<PatientB> patients = new ArrayList<PatientB>();
		for (PatientDTO dto : rList) {
			final PatientB bean = convertDtoToBean(dto);
			patients.add(bean);
		}
		return patients;
	}

	public int getCount(){
		final int count = _patientResource.getCount();
		return count;
	}
	
	@Override
	public PatientB getById(Integer id) {
		final PatientDTO dto = _patientResource.getById(id);
		final PatientB bean = convertDtoToBean(dto);
		return bean;
	}

	@Override
	protected PatientB convertDtoToBean(PatientDTO dto) {
		final Map<String, String> params = new HashMap<String, String>();
		params.put("id", String.valueOf(dto.getId()));
		params.put("name", dto.getName());
		params.put("lastName", dto.getLastName());
		params.put("document", dto.getDocument());
		params.put("address", dto.getAddress());
        params.put("phone", dto.getPhone());
        params.put("mail", dto.getMail());
        final PatientB patientB = new PatientB(params);
		patientB.setSex(dto.getSex());
		patientB.setBirthDate(dto.getBirthDate());    
		return patientB;
	}

	@Override
	protected PatientDTO convertBeanToDto(PatientB bean) {
		final PatientDTO dto = new PatientDTO();
		dto.setId(bean.getId());
		dto.setName(bean.getName());
		dto.setLastName(bean.getLastName());
		dto.setDocument(bean.getDocument());
		dto.setSex(bean.getSex());
		dto.setBirthDate(bean.getBirthDate());
		dto.setAddress(bean.getAddress());
		dto.setMail(bean.getMail());
        dto.setPhone(bean.getPhone());
		return dto;
	}

	@Override
	public List<PatientB> find (String textToFind, int maxItems, int page) {
		final PatientResult result = _patientResource.find(textToFind, maxItems, page);
		final List<PatientDTO> rList = null == result.getPatients() ? new ArrayList<PatientDTO>()
				: result.getPatients();

		final List<PatientB> patients = new ArrayList<PatientB>();
		for (PatientDTO dto : rList) {
			final PatientB bean = convertDtoToBean(dto);
			patients.add(bean);
		}
		return patients;
	}
}
