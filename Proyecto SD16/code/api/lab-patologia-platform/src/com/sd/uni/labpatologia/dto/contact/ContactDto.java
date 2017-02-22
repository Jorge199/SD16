package com.sd.uni.labpatologia.dto.contact;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import com.sd.uni.labpatologia.dto.base.BaseDTO;

@XmlRootElement(name = "contact")
public class ContactDto extends BaseDTO{
	private static final long serialVersionUID = 1L;
	private String _email;
	private String _phone;
	private String _subject;
	private String _message;
	private Integer _userId;

	@XmlElement
	public String getSubject() {
		return _subject;
	}
	
	public void setSubject(String subject) {
		_subject = subject;
	}
	
	@XmlElement
	public String getMessage() {
		return _message;
	}
	
	public void setMessage(String message) {
		_message = message;
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
	public Integer getUserId() {
		return _userId;
	}
	
	public void setUserId(Integer userId) {
		_userId = userId;
	}
}
