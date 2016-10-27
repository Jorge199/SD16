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
	 * @ManyToOne
	 * @JoinColumn(name = "id_ficha") 
	 * @org.hibernate.annotations.ForeignKey(name="FK_ID_FICHA")
	 * private Ficha _id_ficha;
	 */
	@Column(name = "id_ficha", nullable = false)
	private Integer _id_ficha;

	
	@Column(name = "fecha", nullable = false)
	private Date _fecha;

	@Column(name = "diagnostico")
	private String _diagnostico;
	
	@Column(name = "observaciones")
	private String _observaciones;

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public Integer getIdFicha() {
		return _id_ficha;
	}

	public void setIdFicha(Integer id_ficha) {
		_id_ficha = id_ficha;
	}


	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	public String getDiagnostico() {
		return _diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		_diagnostico = diagnostico;
	}
	
	public String getObservaciones() {
		return _observaciones;
	}

	public void setObservaciones(String observaciones) {
		_observaciones = observaciones;
	}

}
