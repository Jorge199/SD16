package com.sd.uni.labpatologia.dto.request;


import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.util.StatusEnum;

@XmlRootElement(name = "request")
public class RequestDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private Integer _patientId;
	private Integer _studyId;
	private Integer _doctorId;
	private Date _date;
	private String _note;
	private Integer _userId;
	private Integer _reportId;
	private String _code;
	private Integer _codeCassette;
	private Integer _codeSheet;
	private StatusEnum _status;
	private String _specimen;
	
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

	@XmlElement
	public Integer getUserId() {
		return _userId;
	}

	public void setUserId(Integer userId) {
		_userId = userId;
	}

	@XmlElement
	public Integer getReportId() {
		return _reportId;
	}

	public void setReportId(Integer reportId) {
		_reportId = reportId;
	}

	@XmlElement
	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}
	
	@XmlElement
	public Integer getCodeCassette() {
		return _codeCassette;
	}

	public void setCodeCassette(Integer code) {
		_codeCassette = code;
	}
	
	@XmlElement
	public Integer getCodeSheet() {
		return _codeSheet;
	}

	public void setCodeSheet(Integer code) {
		_codeSheet = code;
	}

	@XmlElement
	public StatusEnum getStatus() {
		return _status;
	}

	public void setStatus(StatusEnum status) {
		_status = status;
	}

	@XmlElement
	public String getSpecimen() {
		return _specimen;
	}

	public void setSpecimen(String specimen) {
		_specimen = specimen;
	}
	
}
