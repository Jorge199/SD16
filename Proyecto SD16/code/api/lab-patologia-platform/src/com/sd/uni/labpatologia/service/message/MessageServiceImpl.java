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
import org.springframework.stereotype.Service;

import com.sd.uni.labpatologia.dao.message.IMessageDao;
import com.sd.uni.labpatologia.domain.message.MessageDomain;

@Service
public class MessageServiceImpl implements IMessageService{
	@Autowired
	private IMessageDao messageDao;
	
    private boolean send(String toAddress) throws Exception{
    	final String username = "lpatologico@gmail.com";
		final String password = "lpatologico";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toAddress));
			message.setSubject("Notificacion de Analisis Patologico");
			message.setContent("<h2>Hola a todos</h2>", "text/html; charset=utf-8");
			Transport.send(message);
			return true;

		} catch (MessagingException e) {
			return false;
		} 
    }
    
    public void sendNotifications(){
    	System.out.println("Enviando notificaciones...");
    	try {
    		List<MessageDomain> messages = messageDao.findAll();
    		for (MessageDomain msg : messages){
    			if (send(msg.getEmail())){
    				msg.setShippingDate(new Date());
    				msg.setSent(true);
    			}
    		}
			System.out.println("Todas las notificaciones fueron enviadas...");
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

}