package com.sd.uni.labpatologia.service.message;

import java.text.SimpleDateFormat;
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

import com.sd.uni.labpatologia.dao.laboratory.ILaboratoryDao;
import com.sd.uni.labpatologia.dao.message.IMessageDao;
import com.sd.uni.labpatologia.dao.patient.IPatientDao;
import com.sd.uni.labpatologia.dao.request.IRequestDao;
import com.sd.uni.labpatologia.domain.laboratory.LaboratoryDomain;
import com.sd.uni.labpatologia.domain.message.MessageDomain;
import com.sd.uni.labpatologia.domain.patient.PatientDomain;
import com.sd.uni.labpatologia.domain.request.RequestDomain;
import com.sd.uni.labpatologia.exception.PatologyException;

@Service
@Transactional
public class MessageServiceImpl implements IMessageService{
	@Autowired
	private IMessageDao messageDao;
	
	@Autowired
	private IRequestDao requestDao;
	
	@Autowired
	private IPatientDao patientDao;
	
	@Autowired
	private ILaboratoryDao laboratoryDao;
	
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

	@Value("${mail.workingHours}")
	private String workingHours;

	public boolean send(MessageDomain msg) throws PatologyException{
		
		RequestDomain request = requestDao.getById(msg.getId());
		PatientDomain patient = request.getPatient();
		LaboratoryDomain laboratory = laboratoryDao.getById(1);
		if(null != request && null != patient && null != laboratory){
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
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
			
			try {
				String text = "<h3>Estimado/a paciente</h3> <h2>" 
						+ patient.getName() + " " + patient.getLastName() + "</h2>"    
						+ "<br/><p>Cumplimos en informarle que el an&aacute;lisis solicitado en fecha " +  sdf.format(request.getDate())
						+ " se encuentra terminado</p>"
						+ "<p>Nuestro horarios de atenci&oacute;n son los siguientes: </p>"
						+ "<p style=\"padding-left:5%; font-weight: bold;\">" + workingHours + "</p>"
						+ "<br/><p>Atentamente</p>"
						+ "<br/><br/><p style=\"color: blue; font-weight: bold;\">Laboratorio de " + laboratory.getName() + "</p>" 
						+ "<p>Tel&eacute;fono: " + laboratory.getPhone() + "</p>"
						+ "<p>Direcci&oacute;n: " + laboratory.getAddress() + "</p>"
						+ "<p>Email: " + laboratory.getEmail() + "</p>"
						+ "<br/><br/><p style=\"color: red\">Este correo fue autogenerado, favor no responder </p>";
				
				System.out.println("Enviando un mensaje al: "+ msg.getEmail());
				Message message = new MimeMessage(session);
				message.setFrom(new InternetAddress(username));
				message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(msg.getEmail()));
				message.setSubject("Notificacion de Informe");
				message.setContent(text, "text/html; charset=utf-8");
				Transport.send(message);
				return true;

			} catch (MessagingException e) {
				throw new PatologyException("envio mail fallo", e);

			} 
		}else {
			return true;
		}	
	}

	public void sendNotifications() throws PatologyException{

		List<MessageDomain> messages = messageDao.findAll();
		for (MessageDomain msg : messages){
			if (!msg.getSent() && send(msg)){
				msg.setShippingDate(new Date());
				msg.setSent(true);
				messageDao.save(msg);
			}
		}

	}
	
}