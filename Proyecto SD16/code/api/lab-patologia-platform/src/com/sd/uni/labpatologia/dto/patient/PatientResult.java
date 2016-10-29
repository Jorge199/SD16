package com.sd.uni.labpatologia.dto.patient;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;

@XmlRootElement(name = "patientResult")
public class PatientResult extends BaseResult<PatientDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<PatientDTO> getPatients() {
		return getList();
	}

	public void setPatients(List<PatientDTO> dtos) {
		super.setList(dtos);
	}
}
