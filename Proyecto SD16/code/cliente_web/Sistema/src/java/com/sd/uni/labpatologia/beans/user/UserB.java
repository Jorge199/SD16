package com.sd.uni.labpatologia.beans.user;


import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;
import com.sd.uni.labpatologia.beans.rol.RolB;

public class UserB extends BaseBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _password;
	private RolB _rol;

	public UserB(Map<String, String> params) {
		super(params);
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
		setPassword(params.get("password"));
	}

}