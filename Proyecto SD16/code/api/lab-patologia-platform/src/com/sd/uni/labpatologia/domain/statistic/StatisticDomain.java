package com.sd.uni.labpatologia.domain.statistic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.util.DiagnosticEnum;
import com.sd.uni.labpatologia.util.SexEnum;

@Entity
@Table(name = "statistic")
public class StatisticDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "patientAge")
	private Integer _patientAge;
	
	@Enumerated(EnumType.STRING)
	private SexEnum _sex;

	@Enumerated(EnumType.STRING)
	private DiagnosticEnum _diagnostic;
	
	@Column(name = "date", nullable = false)
	private Date _date;

	public Integer getPatientAge() {
		return _patientAge;
	}

	public void setPatientAge(Integer patientAge) {
		_patientAge = patientAge;
	}
	
	public SexEnum getSex() {
		return _sex;
	}

	public void setSex(SexEnum sex) {
		_sex = sex;
	}
	
	public DiagnosticEnum getDiagnostic() {
		return _diagnostic;
	}

	public void setDiagnostic(DiagnosticEnum diagnostic) {
		_diagnostic = diagnostic;
	}
	
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}
}
