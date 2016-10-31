package com.sd.uni.labpatologia.domain.patient;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.domain.request.RequestDomain;



@Entity
@Table(name = "patient")
public class PatientDomain extends BaseDomain {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@OneToMany(mappedBy="_patient")
	private Set<RequestDomain>_requests= new HashSet<RequestDomain>();

	@Column(name = "name")
	private String _name;

	@Column(name = "lastName")
	private String _lastName;

	@Column(name = "document", unique = true)
	private String _document;

	@Column(name = "sex")
	private String _sex;
	
	@Column(name = "birthDate")
	private Date _birthDate;
	
	@Column(name = "address")
	private String _address;
	
	@Column(name = "phone")
	private String _phone;
	

	public Integer getId() {
		return _id;
	}

	public void setId(Integer id) {
		_id = id;
	}

	public void setName(String name) {
		_name = name;
	}
	public String getName() {
		return _name;
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
	
	public String getSex() {
		return _sex;
	}

	public void setSex(String sex) {
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
	
	public Set<RequestDomain> getRequests() {
		return _requests;
	}

	public void setRequests(Set<RequestDomain> requests) {
		_requests = requests;
	}
}
