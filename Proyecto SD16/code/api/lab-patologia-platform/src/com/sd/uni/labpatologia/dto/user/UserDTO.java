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
	private String _registrationNumber;
	private SexEnum _sex;
	private String _accountExpired;
	private String _accountLocked;
	private String _passwordExpired;
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
	public String getRegistrationNumber(){	
		return _registrationNumber;
	}
	
	public void setRegistrationNumber(String registrationNumber){
		_registrationNumber=registrationNumber;
	}
	
	@XmlElement
	public SexEnum getSex() {
		return _sex;
	}

	public void setSex(SexEnum sex) {
		_sex = sex;
	}
	@XmlElement
	public String getAccountExpired() {
		return _accountExpired;
	}

	public void setAccountExpired(String _accountExpired) {
		this._accountExpired = _accountExpired;
	}

	@XmlElement
	public String getAccountLocked() {
		return _accountLocked;
	}

	public void setAccountLocked(String _accountLocked) {
		this._accountLocked = _accountLocked;
	}
	
	@XmlElement
	public String getPasswordExpired() {
		return _passwordExpired;
	}

	public void setPasswordExpired(String _passwordExpired) {
		this._passwordExpired = _passwordExpired;
	}
	
}
