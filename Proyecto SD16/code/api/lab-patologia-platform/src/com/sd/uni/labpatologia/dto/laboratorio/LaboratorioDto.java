package com.sd.uni.labpatologia.dto.laboratorio;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "laboratory")
public class LaboratorioDto extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _address;
	private String _phone;
	private String _email;
	private String _logo;

	@XmlElement
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	@XmlElement
	public String getAddress() {
		return _address;
	}
	
	public void setAddress(String address) {
		_address = address;
	}
	
	@XmlElement
	public String getPhone() {
		return _phone;
	}
	
	public void setPhone(String phone) {
		_phone = phone;
	}
	
	@XmlElement
	public String getEmail() {
		return _email;
	}
	
	public void setEmail(String email) {
		_email = email;
	}
	
	@XmlElement
	public String getLogo() {
		return _logo;
	}
	
	public void setLogo(String logo) {
		_logo = logo;
	}
}
