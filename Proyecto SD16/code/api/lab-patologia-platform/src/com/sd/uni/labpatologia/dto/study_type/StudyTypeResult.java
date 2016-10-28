package com.sd.uni.labpatologia.dto.study_type;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;

@XmlRootElement(name = "study_typeResult")
public class StudyTypeResult extends BaseResult<StudyTypeDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<StudyTypeDTO> getStudies() {
		return getList();
	}

	public void setStudies(List<StudyTypeDTO> dtos) {
		super.setList(dtos);
	}
}
