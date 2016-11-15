package com.sd.uni.labpatologia.beans.user;


import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;
import com.sd.uni.labpatologia.beans.rol.RolB;
import com.sd.uni.labpatologia.util.SexEnum;

public class UserB extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _lastName;
	private String _userName;
	private String _password;
	private RolB _rol;
	private Integer _registrationNumber;
	private SexEnum _sex;
	
	public UserB(Map<String, String> params) {
		super(params);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}
		
	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}

	public RolB getRol() {
		return _rol;
	}
	
	public void setRol(RolB rol) {
		_rol = rol;
	}
	
	public Integer getRegistrationNumber() {
		return _registrationNumber;
	}
	
	public void setRegistrationNumber(Integer registrationNumber) {
		_registrationNumber=registrationNumber;
	}

	public SexEnum getSex() {
		return _sex;
	}

	public void setSex(SexEnum sex) {
		_sex = sex;
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
		setUserName(params.get("userName"));
		setLastName(params.get("lastName"));
		setPassword(params.get("password"));
		try{
			setRegistrationNumber(Integer.valueOf(params.get("registrationNumber")));
		}catch(NumberFormatException nfe){
			
		}
		
	}

}