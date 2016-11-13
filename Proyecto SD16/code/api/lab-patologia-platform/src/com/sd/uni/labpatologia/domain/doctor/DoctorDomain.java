package com.sd.uni.labpatologia.domain.doctor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sd.uni.labpatologia.domain.base.BaseDomain;

@Entity
@Table(name = "doctor")
public class DoctorDomain extends BaseDomain{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "name")
	private String _name;
	
	@Column(name = "last_name")
	private String _last_name;
	
	@Column(name = "ci")
	private Integer _ci;
	
	@Column(name = "address")
	private String _address;
	
	@Column(name = "phone")
	private String _phone;
	
	@Column(name = "email")
	private String _email;
	
	@Column(name = "speciality")
	private String _speciality;
	
	public Integer getId() {
		return _id;
	}
	public void setId(Integer id) {
		_id = id;
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
	
	public String getSpeciality() {
		return _speciality;
	}
	public void setSpeciality(String speciality) {
		_speciality = speciality;
	}
	
	
}
