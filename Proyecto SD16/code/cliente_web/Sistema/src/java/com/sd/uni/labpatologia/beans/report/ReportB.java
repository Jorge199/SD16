package com.sd.uni.labpatologia.beans.report;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;
import com.sd.uni.labpatologia.beans.request.RequestB;

public class ReportB extends BaseBean {
	private static final long serialVersionUID = 1L;
	private Date _date;
	private String _diagnostic;
	private String _observations;
	private RequestB _request;

	public ReportB(Map<String, String> params) {
		super(params);
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setDiagnostic(params.get("diagnostic"));
		setObservations(params.get("observations"));	
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
	public RequestB getRequest() {
		return _request;
	}

	public void setRequest(RequestB request) {
		_request = request;
	}
}
