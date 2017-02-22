package com.sd.uni.labpatologia.service.contact;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.dao.laboratory.ILaboratoryDao;
import com.sd.uni.labpatologia.dao.user.IUserDao;
import com.sd.uni.labpatologia.domain.laboratory.LaboratoryDomain;
import com.sd.uni.labpatologia.domain.user.UserDomain;
import com.sd.uni.labpatologia.dto.contact.ContactDto;
import com.sd.uni.labpatologia.exception.PatologyException;


@Service
public class ContactServiceImpl implements IContactService {

	@Autowired
	private static Logger logger = Logger.getLogger(ContactServiceImpl.class);

	@Autowired
	private IUserDao userDao;
	
	@Autowired
	private ILaboratoryDao laboratoryDao;
	
	@Value("${mail.username:lpatologico@gmail.com}")
	private String username;
	
	@Value("${mail.password:lpatologico}")
	private String password;
	
	
	@Override
	public ContactDto sent(ContactDto contactDto) throws PatologyException {
		LaboratoryDomain laboratory = laboratoryDao.getById(1);
		UserDomain user = userDao.getById(contactDto.getUserId());
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			String text = "<h3>Notificaci&oacute;n de contacto</h3>"    
					+ "<br/><p>El usuario  <strong>" +  user.getName() + " " + user.getLastName() + "</strong> "
					+ "ha realizado una consulta sobre el Sistema desarrollado en la materia Sistemas Distribuidos - 2016 "
					+ "para el laboratorio Patol&oacute;gico de Encarnaci&oacute;n. El mismo es el siguiente:</p>"
					+ "<br/><p style=\"padding-left:5%;\">Mensaje: " + contactDto.getMessage() + "</p>"
					+ "<br/><p>Sus datos de contacto son: </p>"
					+ "<p>Tel&eacute;fono: " + contactDto.getPhone() + "</p>"
					+ "<p>Email: " + contactDto.getEmail() + "</p>"
					+ "<br/><p>Atentamente</p>"
					+ "<br/><br/><p style=\"color: blue; font-weight: bold;\">Laboratorio de " + laboratory.getName() + "</p>" 
					+ "<p>Tel&eacute;fono: " + laboratory.getPhone() + "</p>"
					+ "<p>Direcci&oacute;n: " + laboratory.getAddress() + "</p>"
					+ "<p>Email: " + laboratory.getEmail() + "</p>"
					+ "<br/><br/><p style=\"color: red\">Este correo fue autogenerado, favor no responder </p>";
			
			System.out.println("Enviando un mensaje al grupo");
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("fa.talavera95@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("taniamonges@gmail.com"));
			message.setSubject("Contacto: " + contactDto.getSubject());
			message.setContent(text, "text/html; charset=utf-8");
			Transport.send(message);

		} catch (MessagingException e) {
			throw new PatologyException("envio mail fallo", e);
		} 
		return contactDto;
	}

}


