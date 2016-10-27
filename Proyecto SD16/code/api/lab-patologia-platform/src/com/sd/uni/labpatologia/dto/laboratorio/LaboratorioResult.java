package com.sd.uni.labpatologia.dto.laboratorio;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;
import java.util.List;

@XmlRootElement(name = "laboratoryResult")
public class LaboratorioResult extends BaseResult<LaboratorioDto>{
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<LaboratorioDto> getLaboratory() {
		return getList();
	}

	public void setLaboratories(List<LaboratorioDto> dtos) {
		super.setList(dtos);
	}

}
