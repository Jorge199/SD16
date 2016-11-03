package com.sd.uni.labpatologia.beans.request;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;

public class RequestB extends BaseBean {

	private static final long serialVersionUID = 1L;
	private String _note;
	private Date _date;
	/*private DoctorB _doctor;
	private PatientB _patient;
	private StudyType _studyType;*/

	public RequestB(Map<String, String> params) {
		super(params);
	}

	
	public String getNote() {
		return _note;
	}


	public void setNote(String note) {
		_note = note;
	}


	public Date getDate() {
		return _date;
	}


	public void setDate(Date date) {
		_date = date;
	}


	/*public DoctorB getDoctor() {
		return _doctor;
	}


	public void setDoctor(DoctorB doctor) {
		_doctor = doctor;
	}


	public PatientB getPatient() {
		return _patient;
	}


	public void setPatient(PatientB patient) {
		_patient = patient;
	}


	public StudyType getStudyType() {
		return _studyType;
	}


	public void setStudyType(StudyType studyType) {
		_studyType = studyType;
	}*/


	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setNote(params.get("note"));
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			setDate(formato.parse(params.get("date")));
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
