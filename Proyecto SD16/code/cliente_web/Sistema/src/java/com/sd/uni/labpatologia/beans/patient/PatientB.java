
package com.sd.uni.labpatologia.beans.patient;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.sd.uni.labpatologia.beans.base.BaseBean;
import com.sd.uni.labpatologia.util.SexEnum;

public class PatientB extends BaseBean {
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _lastName;
	private String _document;
	private SexEnum _sex;
	private Date _birthDate;
	private String _address;
	private String _phone;
	private String _fullName;

	public String getFullName() {
		return _name + " " + _lastName;
	}
	
	public void setFullName(String name) {
		_fullName = name;
	}
	
	public PatientB(Map<String, String> params) {
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

	public String getDocument() {
		return _document;
	}

	public void setDocument(String document) {
		_document = document;
	}
	
	public SexEnum getSex() {
		return _sex;
	}

	public void setSex(SexEnum sex) {
		_sex = sex;
	}

	public Date getBirthDate() {
		return _birthDate;
	}

	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;
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
	
	@Override
	protected void create(Map<String, String> params) {
		if (!StringUtils.isBlank(params.get("id"))) {
			setId(Integer.valueOf(params.get("id")));
		}
		setName(params.get("name"));
		setLastName(params.get("lastName"));	
        setDocument(params.get("document"));
        setAddress(params.get("address"));
        setPhone(params.get("phone"));
        setFullName(params.get("name") + " " + params.get("lastName"));
	}
}
