package com.sd.uni.labpatologia.service.message;

import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.message.IMessageDao;
import com.sd.uni.labpatologia.domain.message.MessageDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService{
	@Autowired
	private IMessageDao messageDao;
	
	@Value("${mail.username:lpatologico@gmail.com}")
	private String username;
	
	@Value("${mail.password:lpatologico}")
	private String password;
	
	@Value("${mail.smtp.auth:true}")
	private String auth;
	
	@Value("${mail.smtp.starttls.enable:true}")
	private String enable;
	
	@Value("${mail.host:smtp.gmail.com}")
	private String host;
	
	@Value("${mail.port:587}")
	private String port;

	public boolean send(String toAddress) throws PatologyException{
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("lpatologico@gmail.com", "lpatologico");
			}
		});

		try {
			String text = "<h3>Estimado/a paciente: </h3>"
					+ "<p>Cumplimos en informarle que su análisis se encuentra realizado</p>"
					+ "<p>Atentamente</p>";
			System.out.println("Enviando un mensaje al: "+ toAddress);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("lpatologico@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
			message.setSubject("Notificacion de Informe");
			message.setContent(text, "text/html; charset=utf-8");
			Transport.send(message);
			return true;

		} catch (MessagingException e) {
			throw new PatologyException("envio mail fallo", e);

		} 
	}

	public void sendNotifications() throws PatologyException{

		List<MessageDomain> messages = messageDao.findAll();
		for (MessageDomain msg : messages){
			if (!msg.getSent() && send(msg.getEmail())){
				msg.setShippingDate(new Date());
				msg.setSent(true);
				messageDao.save(msg);
			}
		}

	}
	
}