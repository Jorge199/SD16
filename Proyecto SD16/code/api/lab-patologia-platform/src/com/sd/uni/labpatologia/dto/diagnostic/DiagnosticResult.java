package com.sd.uni.labpatologia.dto.diagnostic;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;

@XmlRootElement(name = "diagnosticResult")
public class DiagnosticResult extends BaseResult<DiagnosticDto>{
	private static final long serialVersionUID = 1L;


	@XmlElement
	public List<DiagnosticDto> getDiagnostics() {
		return getList();
	}

	public void setDiagnostics(List<DiagnosticDto> dtos) {
		super.setList(dtos);
	}
	
}
