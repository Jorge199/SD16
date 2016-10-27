package com.sd.uni.labpatologia.dto.report;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "report")
public class ReportDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private Integer _id_ficha;
	private String _diagnostico;
	private Date _fecha;
	private String _observaciones;

	
	@XmlElement
	public Integer getIdFicha() {
		return _id_ficha;
	}

	public void setIdFicha(Integer id_ficha) {
		_id_ficha= id_ficha;
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
