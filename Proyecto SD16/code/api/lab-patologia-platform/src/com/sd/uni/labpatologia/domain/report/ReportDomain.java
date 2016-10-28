package com.sd.uni.labpatologia.domain.report;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;

@Entity
@Table(name = "report")
public class ReportDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	/**
	 * Cuando se tenga la relacion se reemplazara con:
	 * 
	 * @ManyToOne
	 * @JoinColumn(name = "id_ficha")
	 * @org.hibernate.annotations.ForeignKey(name="FK_ID_FICHA") private Ficha
	 *                                                           _id_ficha;
	 */
	@Column(name = "requestId", nullable = false)
	private Integer _requestId;

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

	public Integer getRequestId() {
		return _requestId;
	}

	public void setRequestId(Integer requestId) {
		_requestId = requestId;
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
