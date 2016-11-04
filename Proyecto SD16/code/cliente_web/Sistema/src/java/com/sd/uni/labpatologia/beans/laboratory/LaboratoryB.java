package com.sd.uni.labpatologia.beans.laboratory;


import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;

public class LaboratoryB extends BaseBean{
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _address;
	private String _email;
	private String _phone;
	private LaboratoryB _laboratory;
	
	public LaboratoryB(Map<String, String> params) {
		super(params);
	}
	
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}
	
	public String getPhone() {
		return _phone;
	}
	public void setPhone(String phone) {
		_phone = phone;
	}
	
	public LaboratoryB getLaboratory() {
		return _laboratory;
	}
	public void setLaboratory(LaboratoryB laboratory) {
		_laboratory = laboratory;
	}
	
	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
		setAddress(params.get("address"));
		setEmail(params.get("email"));
		setPhone(params.get("phone"));
		
	}

}
