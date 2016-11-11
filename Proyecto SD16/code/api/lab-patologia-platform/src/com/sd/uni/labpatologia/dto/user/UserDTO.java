package com.sd.uni.labpatologia.dto.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "user")
public class UserDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _password;
	private Integer _rolId;
	private boolean _doctor;
	private String _matricula;
	

	@XmlElement
	public String getName() {
		return _name;
	}
	
	@XmlElement
	public String getPassword() {
		return _password;
	}
	
	@XmlElement
	public Integer getRolId() {
		return _rolId;
	}
	
	@XmlElement
	public boolean getDoctor(){
		return _doctor;
	}
	
	@XmlElement
	public String getMatricula(){	
		return _matricula;
	}
	

	public void setName(String name) {
		_name = name;
	}
	
	public void setPassword(String password) {
		_password = password;
	}

	public void setRolId(Integer rolId) {
		_rolId = rolId;
	}
	
	public void setMatricula(String matricula){
		_matricula=matricula;
	}
	
	public void setDoctor(boolean doctor){
		_doctor=doctor;
	}
	
}
