package com.sd.uni.labpatologia.dto.doctor;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;

import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "doctor")
public class DoctorDto extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String _name;
	private String _last_name;
	private String _ci;
	private String _address;
	private String _phone;
	private String _email;
	private String _speciality;


	@XmlElement
	public String getName() {
		return _name;
	}
	
	public void setName(String name) {
		_name = name;
	}
	
	@XmlElement
	public String getLastName() {
		return _last_name;
	}
	
	public void setLastName(String name) {
		_last_name = name;
	}
	
	@XmlElement
	public String getCi() {
		return _ci;
	}
	public void setCi(String ci) {
		_ci = ci;
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
	public String getEmail() {
		return _email;
	}
	
	public void setEmail(String email) {
		_email = email;
	}
	
	@XmlElement
	public String getSpeciality() {
		return _speciality;
	}
	
	public void setSpeciality(String speciality) {
		_speciality = speciality;
	}
}
