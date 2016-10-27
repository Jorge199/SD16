package com.sd.uni.labpatologia.dto.request;


import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "request")
public class RequestDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _patientId;
	private Integer _studyId;
	private Integer _doctorId;
	private Date _date;
	private String _note;
	
	@XmlElement
	public Integer getPatientId() {
		return _patientId;
	}

	public void setPatientId(Integer patientId) {
		_patientId = patientId;
	}
	
	@XmlElement
	public Integer getStudyId() {
		return _studyId;
	}

	public void setStudyId(Integer studyId) {
		_studyId = studyId;
	}
	
	@XmlElement
	public Integer getDoctorId() {
		return _doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		_doctorId = doctorId;
	}
	
	@XmlElement
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}
	
	@XmlElement
	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

}
