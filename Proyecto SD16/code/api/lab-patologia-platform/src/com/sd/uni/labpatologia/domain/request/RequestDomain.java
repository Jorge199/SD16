package com.sd.uni.labpatologia.domain.request;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.domain.doctor.DoctorDomain;
import com.sd.uni.labpatologia.domain.patient.PatientDomain;
import com.sd.uni.labpatologia.domain.report.ReportDomain;
import com.sd.uni.labpatologia.domain.study_type.StudyTypeDomain;

@Entity
@Table(name = "request")
public class RequestDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@OneToMany(mappedBy="_request")
	private Set<ReportDomain>_reports= new HashSet<ReportDomain>();
	
	@ManyToOne
	private PatientDomain _patient;
	
	@ManyToOne
	private StudyTypeDomain _studyType;
	
	@ManyToOne
	private DoctorDomain _doctor;

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

	public Set<ReportDomain> getReports() {
		return _reports;
	}

	public void setReports(Set<ReportDomain> reports) {
		_reports = reports;
	}

	public PatientDomain getPatient() {
		return _patient;
	}

	public void setPatient(PatientDomain patient) {
		_patient = patient;
	}

	public StudyTypeDomain getStudyType() {
		return _studyType;
	}

	public void setStudyType(StudyTypeDomain studyType) {
		_studyType = studyType;
	}

	public DoctorDomain getDoctor() {
		return _doctor;
	}

	public void setDoctor(DoctorDomain doctor) {
		_doctor = doctor;
	}
	
}

