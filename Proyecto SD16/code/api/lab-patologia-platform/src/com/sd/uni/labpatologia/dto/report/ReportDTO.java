package com.sd.uni.labpatologia.dto.report;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "report")
public class ReportDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Integer _id_paciente;
	private Integer _id_doctor;
	private Integer _id_estudio;
	private String _diagnostico;
	private Date _fecha;
	private String _observaciones;

	@XmlElement
	public Integer getIdDoctor() {
		return _id_doctor;
	}

	public void setIdDoctor(Integer id_doctor) {
		_id_doctor = id_doctor;
	}
	
	@XmlElement
	public Integer getIdPaciente() {
		return _id_paciente;
	}

	public void setIdPaciente(Integer id_paciente) {
		_id_paciente = id_paciente;
	}
	
	@XmlElement
	public Integer getIdEstudio() {
		return _id_estudio;
	}

	public void setIdEstudio(Integer id_estudio) {
		_id_estudio= id_estudio;
	}

	@XmlElement
	public String getDiagnostico() {
		return _diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		_diagnostico = diagnostico;
	}
	
	@XmlElement
	public Date getFecha() {
		return _fecha;
	}

	public void setFecha(Date fecha) {
		_fecha = fecha;
	}

	@XmlElement
	public String getObservaciones() {
		return _observaciones;
	}

	public void setObservaciones(String observaciones) {
		_observaciones = observaciones;
	}

}
