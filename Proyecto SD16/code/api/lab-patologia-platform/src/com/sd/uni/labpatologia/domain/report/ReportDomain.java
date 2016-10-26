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

	@Column(name = "id_doctor", nullable = false)
	private Integer _id_doctor;

	@Column(name = "id_paciente", nullable = false)
	private Integer _id_paciente;
	
	@Column(name = "id_estudio", nullable = false)
	private Integer _id_estudio;

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

	public Integer getIdDoctor() {
		return _id_doctor;
	}

	public void setIdDoctor(Integer id_doctor) {
		_id_doctor = id_doctor;
	}

	public Integer getIdPaciente() {
		return _id_paciente;
	}

	public void setIdPaciente(Integer id_paciente) {
		_id_paciente = id_paciente;
	}
	
	public Integer getIdEstudio() {
		return _id_estudio;
	}

	public void setIdEstudio(Integer id_estudio) {
		_id_estudio = id_estudio;
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
