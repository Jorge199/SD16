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

}
