package com.sd.uni.labpatologia.dto.diagnostic;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "diagnostic")
public class DiagnosticDto extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _description;

	@XmlElement
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	@XmlElement
	public String getDescription() {
		return _description;
	}
	
	public void setDescription(String description) {
		_description = description;
	}
	
}
