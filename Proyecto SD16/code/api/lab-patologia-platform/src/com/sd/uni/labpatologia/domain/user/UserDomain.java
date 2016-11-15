package com.sd.uni.labpatologia.domain.user;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.domain.rol.RolDomain;
import com.sd.uni.labpatologia.util.SexEnum;

@Entity
@Table(name = "user")
public class UserDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "userName", nullable = false)//. unique = true)
	private String _userName;
	
	@Column(name = "name", nullable = true)
	private String _name;
	
	@Column(name = "lastName", nullable = true)
	private String _lastName;
	
	@Column(name = "password", nullable = false, unique = false)
	private String _password;
	
	@Column(name = "registrationNumber", nullable = true)
	private Integer _registrationNumber;
	
	@Enumerated(EnumType.STRING)
	private SexEnum _sex;

	@ManyToOne
	private RolDomain _rol;
	
	
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
	
	public String getUserName() {
		return _userName;
	}

	public void setUserName(String user_name) {
		_userName = user_name;
	}
	
	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String last_name) {
		_lastName = last_name;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password, Integer id) {
		if(null==id){
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);
			_password = hashedPassword;
		}else{
			_password = password;
		}		
	}
	
	public RolDomain getRol() {
		return _rol;
	}

	public void setRol(RolDomain rol) {
		_rol = rol;
	}
	
	public Integer getRegistrationNumber(){	
		return _registrationNumber;
	}
	
	public void setRegistrationNumber(Integer registrationNumber){
		_registrationNumber=registrationNumber;
	}

	public SexEnum getSex() {
		return _sex;
	}

	public void setSex(SexEnum sex) {
		_sex = sex;
	}
	
	
	
}
