package com.sd.uni.labpatologia.domain.user;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


import com.sd.uni.labpatologia.domain.base.BaseDomain;
import com.sd.uni.labpatologia.domain.rol.RolDomain;

@Entity
@Table(name = "user")
public class UserDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;

	@Column(name = "name", nullable = false, unique = true)
	private String _name;
	
	@Column(name = "password", nullable = false, unique = false)
	private String _password;
	
	@Column(name = "doctor", nullable = false, unique = false)
	private boolean _doctor;
	
	@Column(name = "matricula", nullable = true, unique = false)
	private String _matricula;

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
	

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
	}
	
	public RolDomain getRol() {
		return _rol;
	}

	public void setRol(RolDomain rol) {
		_rol = rol;
	}

	public boolean getDoctor(){
		return _doctor;
	}
	
	
	public String getMatricula(){	
		return _matricula;
	}
	
	public void setMatricula(String matricula){
		_matricula=matricula;
	}
	
	public void setDoctor(boolean doctor){
		_doctor=doctor;
	}
}
