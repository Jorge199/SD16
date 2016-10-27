package com.sd.uni.labpatologia.domain.request;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;

@Entity
@Table(name = "request")
public class RequestDomain extends BaseDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "patientId")
	private Integer _patientId;

	@Column(name = "studyId")
	private Integer _studyId;

	@Column(name = "doctorId")
	private Integer _doctorId;

	@Column(name = "date")
	private Date _date;
	
	@Column(name = "note")
	private String _note;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public Integer getPatientId() {
		return _patientId;
	}

	public void setPatientId(Integer patientId) {
		_patientId = patientId;
	}

	public Integer getStudyId() {
		return _studyId;
	}

	public void setStudyId(Integer studyId) {
		_studyId = studyId;
	}

	public Integer getDoctorId() {
		return _doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		_doctorId = doctorId;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}
	
	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

}

