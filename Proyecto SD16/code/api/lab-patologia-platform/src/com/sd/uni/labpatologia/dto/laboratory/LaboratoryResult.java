package com.sd.uni.labpatologia.dto.laboratory;

import javax.xml.bind.annotation.XmlRootElement;

import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;
import com.sd.uni.labpatologia.dto.laboratory.LaboratoryDto;

import java.util.List;

@XmlRootElement(name = "laboratoryResult")
public class LaboratoryResult extends BaseResult<LaboratoryDto>{
	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<LaboratoryDto> getLaboratories() {
		return getList();
	}

	public void setLaboratories(List<LaboratoryDto> dtos) {
		super.setList(dtos);
	}

}
