package com.sd.uni.labpatologia.domain.message;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sd.uni.labpatologia.domain.base.BaseDomain;

public class MessageDomain extends BaseDomain {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", nullable = false, unique = true)
	private Integer _id;
	
	@Column(name = "email")
	private String _email;
	
	@Column(name = "phone")
	private String _phone;
	
	//fecha creacion
	@Column(name = "creationDate")
	private Date _creationDate;
	
	//fecha de envio
	@Column(name = "shippingDate")
	private Date _shippingDate;
	
	//estado enviado
	@Column(name = "sent")
	private boolean _sent;
	
	public Integer getId(){
		return _id;
	}
	
	public void setId(Integer id){
		_id = id;
	}
	
	public String getEmail(){
		return _email;
	}
	
	public void setEmail(String email){
		_email = email;
	}
	
	public String getPhone(){
		return _phone;
	}
	
	public void setPhone(String phone){
		_phone = phone;
	}
	
	public Date getCreationDate(){
		return _creationDate;
	}
	
	public void setCreationDate(Date creationDate){
		_creationDate = creationDate;
	}
	
	public Date getShippingDate(){
		return _shippingDate;
	}
	
	public void setShippingDate(Date shippingDate){
		_shippingDate = shippingDate;
	}
	
	public boolean getSent(){
		return _sent;
	}
	
	public void setSent(boolean sent){
		_sent = sent;
	}
	
	
}
