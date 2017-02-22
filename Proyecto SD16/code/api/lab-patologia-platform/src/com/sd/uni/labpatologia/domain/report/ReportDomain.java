package com.sd.uni.labpatologia.domain.report;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.domain.request.RequestDomain;
import com.sd.uni.labpatologia.domain.statistic.StatisticDomain;
import com.sd.uni.labpatologia.util.DiagnosticEnum;

@Entity
@Table(name = "report")
public class ReportDomain extends BaseDomain {
	@Id
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@ManyToOne
	private RequestDomain _request;

	@Column(name = "date", nullable = false)
	private Date _date;

	@Column(name = "observations", length = 10000)
	private String _observations;

	@Enumerated(EnumType.STRING)
	private DiagnosticEnum _diagnostic;

	@Column(name = "diagnosticDetail")
	private String _diagnosticDetail;

	@Column(name = "age")
	private Integer _age;
	
	@Column(name = "isProcessed")
	private Boolean _isProcessed;

	@OneToOne
	private StatisticDomain _statistic;
	
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

	public String getObservations() {
		return _observations;
	}

	public void setObservations(String observations) {
		_observations = observations;
	}

	public DiagnosticEnum getDiagnostic() {
		return _diagnostic;
	}

	public void setDiagnostic(DiagnosticEnum diagnostic) {
		_diagnostic = diagnostic;
	}

	public Integer getAge() {
		return _age;
	}

	public void setAge(Integer age) {
		_age = age;
	}

	public Boolean getIsProcessed() {
		return _isProcessed;
	}

	public void setIsProcessed(Boolean isProcessed) {
		_isProcessed = isProcessed;
	}

	public StatisticDomain getStatistic() {
		return _statistic;
	}

	public void setStatistic(StatisticDomain statistic) {
		_statistic = statistic;
	}
	
	public String getDiagnosticDetail(){
		return _diagnosticDetail;
	}
	
	public void setDiagnosticDetail(String diagnosticDetail){
		_diagnosticDetail = diagnosticDetail;
	}
	
}
