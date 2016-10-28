package com.sd.uni.labpatologia.dto.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "user")
public class UserDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _password;

	@XmlElement
	public String getName() {
		return _name;
	}
	
	@XmlElement
	public String getPassword() {
		return _password;
	}

	public void setName(String name) {
		_name = name;
	}
	
	public void setPassword(String password) {
		_password = password;
	}

}
