/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sd.uni.labpatologia.beans.doctor;

/**
 *
 * @author User
 */
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;

public class DoctorB extends BaseBean {
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _last_name;
	private Integer _ci;
	private String _address;
	private String _phone;
	private String _email;
	//private RequestB _request;

	public DoctorB(Map<String, String> params) {
		super(params);
	}

	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
		setLastName(params.get("last_name"));	
                setCi(Integer.parseInt(params.get("ci")));
                setLastName(params.get("last_name"));
                setAddress(params.get("address"));
                setPhone(params.get("phone"));
                setEmail(params.get("email"));
	}

	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	public String getLastName() {
		return _last_name;
	}
	
	public void setLastName(String name) {
		_last_name = name;
	}
	
	public Integer getCi() {
		return _ci;
	}
	public void setCi(Integer ci) {
		_ci = ci;
	}
	
	public String getAddress() {
		return _address;
	}
	
	public void setAddress(String address) {
		_address = address;
	}
	
	public String getPhone() {
		return _phone;
	}
	
	public void setPhone(String phone) {
		_phone = phone;
	}
	
	public String getEmail() {
		return _email;
	}
	
	public void setEmail(String email) {
		_email = email;
	}
}
