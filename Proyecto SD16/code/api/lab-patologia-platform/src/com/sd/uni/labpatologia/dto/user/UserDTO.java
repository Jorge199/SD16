package com.sd.uni.labpatologia.dto.user;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.util.SexEnum;

@XmlRootElement(name = "user")
public class UserDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _userName;
	private String _lastName;
	private String _password;
	private Integer _rolId;
	private String _matricula;
	private SexEnum _sex;

	@XmlElement
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	@XmlElement
	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	@XmlElement
	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}
	
	@XmlElement
	public String getPassword() {
		return _password;
	}
	
	public void setPassword(String password) {
		_password = password;
	}
	
	@XmlElement
	public Integer getRolId() {
		return _rolId;
	}
	
	public void setRolId(Integer rolId) {
		_rolId = rolId;
	}
	
	@XmlElement
	public String getMatricula(){	
		return _matricula;
	}
	
	public void setMatricula(String matricula){
		_matricula=matricula;
	}
	
	@XmlElement
	public SexEnum getSex() {
		return _sex;
	}

	public void setSex(SexEnum sex) {
		_sex = sex;
	}
	
	
}
