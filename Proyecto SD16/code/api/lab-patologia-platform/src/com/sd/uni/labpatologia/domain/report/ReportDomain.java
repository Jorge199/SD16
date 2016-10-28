package com.sd.uni.labpatologia.domain.report;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.domain.request.RequestDomain;

@Entity
@Table(name = "report")
public class ReportDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@ManyToOne
	private RequestDomain _request;

	@Column(name = "date", nullable = false)
	private Date _date;

	@Column(name = "diagnostic")
	private String _diagnostic;

	@Column(name = "observations")
	private String _observations;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public RequestDomain getRequest() {
		return _request;
	}

	public void setRequest(RequestDomain request) {
		_request = request;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public String getDiagnostic() {
		return _diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		_diagnostic = diagnostic;
	}

	public String getObservations() {
		return _observations;
	}

	public void setObservations(String observations) {
		_observations = observations;
	}

}
