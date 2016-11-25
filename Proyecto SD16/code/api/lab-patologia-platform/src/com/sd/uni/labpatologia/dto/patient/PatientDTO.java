package com.sd.uni.labpatologia.dto.patient;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;
import com.sd.uni.labpatologia.util.SexEnum;

@XmlRootElement(name = "patient")
public class PatientDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;
	private String _name;
	private String _lastName;
	private String _document;
	private SexEnum _sex;
	private Date _birthDate;
	private String _address;
	private String _phone;
	private String _mail;

	@XmlElement
	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	@XmlElement
	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@XmlElement
	public String getDocument() {
		return _document;
	}

	public void setDocument(String document) {
		_document = document;
	}

	@XmlElement
	public SexEnum getSex() {
		return _sex;
	}

	public void setSex(SexEnum sex) {
		_sex = sex;
	}
	
	@XmlElement
	public Date getBirthDate() {
		return _birthDate;
	}

	public void setBirthDate(Date birthDate) {
		_birthDate = birthDate;
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
	public String getMail() {
		return _mail;
	}

	public void setMail(String mail) {
		_mail = mail;
	}
}
