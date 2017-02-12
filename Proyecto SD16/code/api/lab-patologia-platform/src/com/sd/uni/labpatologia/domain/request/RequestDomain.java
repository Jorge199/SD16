package com.sd.uni.labpatologia.domain.request;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.domain.doctor.DoctorDomain;
import com.sd.uni.labpatologia.domain.patient.PatientDomain;
import com.sd.uni.labpatologia.domain.report.ReportDomain;
import com.sd.uni.labpatologia.domain.study_type.StudyTypeDomain;
import com.sd.uni.labpatologia.domain.user.UserDomain;
import com.sd.uni.labpatologia.util.StatusEnum;

@Entity
@Table(name = "request")
public class RequestDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@ManyToOne
	private PatientDomain _patient;
	
	@ManyToOne
	private StudyTypeDomain _studyType;
	
	@ManyToOne
	private DoctorDomain _doctor;
	
	@ManyToOne
	private UserDomain _user;
	
	@OneToOne
	private ReportDomain _report;

	@Column(name = "date")
	private Date _date;

	@Column(name = "note")
	private String _note;
	
	@Column(name = "code")
	private String _code;
	
	@Column(name = "codeCassette")
	private Integer _codeCassette;
	
	@Column(name = "codeSheet")
	private Integer _codeSheet;
	
	@Enumerated(EnumType.STRING)
	private StatusEnum _status;
	
	@Column(name = "specimen")
	private String _specimen;

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

	public UserDomain getUser() {
		return _user;
	}

	public void setUser(UserDomain user) {
		_user = user;
	}

	public ReportDomain getReport() {
		return _report;
	}

	public void setReport(ReportDomain report) {
		_report = report;
	}

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}
	
	public Integer getCodeCassette() {
		return _codeCassette;
	}

	public void setCodeCassette(Integer code) {
		_codeCassette = code;
	}
	
	public Integer getCodeSheet() {
		return _codeSheet;
	}

	public void setCodeSheet(Integer code) {
		_codeSheet = code;
	}

	public StatusEnum getStatus() {
		return _status;
	}

	public void setStatus(StatusEnum status) {
		_status = status;
	}

	public String getSpecimen() {
		return _specimen;
	}

	public void setSpecimen(String specimen) {
		_specimen = specimen;
	}

}

