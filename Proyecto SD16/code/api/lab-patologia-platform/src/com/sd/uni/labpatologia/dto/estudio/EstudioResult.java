package com.sd.uni.labpatologia.dto.estudio;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseResult;

@XmlRootElement(name = "estudioResult")
public class EstudioResult extends BaseResult<EstudioDTO> {

	private static final long serialVersionUID = 1L;

	@XmlElement
	public List<EstudioDTO> getEstudios() {
		return getList();
	}

	public void setEstudios(List<EstudioDTO> dtos) {
		super.setList(dtos);
	}
}
