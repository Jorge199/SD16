package com.sd.uni.labpatologia.domain.statistic;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.domain.diagnostic.DiagnosticDomain;
import com.sd.uni.labpatologia.domain.doctor.DoctorDomain;
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
	
	@ManyToOne
	private DiagnosticDomain _diagnostic;
	
	@Column(name = "date", nullable = false)
	private Date _date;
	
	//@OneToOne
	//private ReportDomain _report;
	
	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

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
	
	public DiagnosticDomain getDiagnostic() {
		return _diagnostic;
	}

	public void setDiagnostic(DiagnosticDomain diagnostic) {
		_diagnostic = diagnostic;
	}
	
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}
	/*
    public ReportDomain getReport() {
        return _report;
    }
    
    public void setReport(ReportDomain report){
    	_report=report;
    }
	*/
	
}
