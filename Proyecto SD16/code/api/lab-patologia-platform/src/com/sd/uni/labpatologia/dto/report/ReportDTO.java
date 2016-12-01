package com.sd.uni.labpatologia.dto.report;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

@XmlRootElement(name = "report")
public class ReportDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Integer _requestId;
	private DiagnosticEnum _diagnostic;
	private Date _date;
	private String _observations;
	private Integer _age;
	private Boolean _isProcessed;
	private Integer _statisticId;

	@XmlElement
	public Integer getRequestId() {
		return _requestId;
	}

	public void setRequestId(Integer requestId) {
		_requestId= requestId;
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
	public String getObservations() {
		return _observations;
	}

	public void setObservations(String observations) {
		_observations = observations;
	}

	@XmlElement
	public Integer getAge() {
		return _age;
	}

	public void setAge(Integer age) {
		_age = age;
	}

	@XmlElement
	public Boolean getIsProcessed() {
		return _isProcessed;
	}

	public void setIsProcessed(Boolean isProcessed) {
		_isProcessed = isProcessed;
	}
	
	@XmlElement
	public Integer getStatisticId() {
		return _statisticId;
	}

	public void setStatisticId(Integer statisticId) {
		_statisticId = statisticId;
	}
}
