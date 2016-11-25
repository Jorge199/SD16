package com.sd.uni.labpatologia.dto.statistic;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.util.DiagnosticEnum;
import com.sd.uni.labpatologia.util.SexEnum;

@XmlRootElement(name = "statistic")
public class StatisticDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	
	private Integer _patientAge;
	private DiagnosticEnum _diagnostic;
	private Date _date;
	private SexEnum _sex;
	

	@XmlElement
	public Integer getPatientAge() {
		return _patientAge;
	}

	public void setPatientAge(Integer patientAge) {
		_patientAge = patientAge;
	}
	
	@XmlElement
	public DiagnosticEnum getDiagnostic() {
		return _diagnostic;
	}

	public void setDiagnostic(DiagnosticEnum diagnostic) {
		_diagnostic = diagnostic;
	}

	@XmlElement
	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	@XmlElement
	public SexEnum getSex() {
		return _sex;
	}

	public void setSex(SexEnum sex) {
		_sex = sex;
	}
}
