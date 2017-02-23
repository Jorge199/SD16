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
import org.springframework.transaction.annotation.Transactional;

import com.sd.uni.labpatologia.dao.contact.ContactDaoImpl;
import com.sd.uni.labpatologia.dao.contact.IContactDao;
import com.sd.uni.labpatologia.dao.laboratory.ILaboratoryDao;
import com.sd.uni.labpatologia.domain.contact.ContactDomain;
import com.sd.uni.labpatologia.domain.laboratory.LaboratoryDomain;
import com.sd.uni.labpatologia.dto.contact.ContactDto;
import com.sd.uni.labpatologia.dto.contact.ContactResult;
import com.sd.uni.labpatologia.exception.PatologyException;
import com.sd.uni.labpatologia.service.base.BaseServiceImpl;


@Service
public class ContactServiceImpl extends BaseServiceImpl<ContactDto, ContactDomain, ContactDaoImpl, ContactResult> implements IContactService{
	@Autowired
	private IContactDao contactDao;
	
	@Autowired
	private ILaboratoryDao laboratoryDao;
	
	private static Logger logger = Logger.getLogger(ContactServiceImpl.class);
	
	@Value("${mail.username:lpatologico@gmail.com}")
	private String username;
	
	@Value("${mail.password:lpatologico}")
	private String password;
	
	@Override
	@Transactional
	public ContactDto save(ContactDto dto) {
		try { 
		    // Lanzo exepcion de tipo runtime para realizar rollback
			final ContactDomain contactDomain = convertDtoToDomain(dto);
			final ContactDomain contact = contactDao.save(contactDomain);
			final ContactDto newDto = convertDomainToDto(contact);
			sent(newDto);
			return newDto;
		} catch(PatologyException ex) { 
			 logger.error(ex);
			 throw new RuntimeException("Error"+ContactServiceImpl.class+"" + ex.getMessage(), ex); 
		}
		
	}

	@Override
	@Transactional(readOnly = true)
	public ContactDto getById(Integer id) throws PatologyException {
		final ContactDomain contactDomain = contactDao.getById(id);
		final ContactDto contactDTO = convertDomainToDto(contactDomain);
		return contactDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public ContactResult getAll() {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public ContactResult find(String textToFind, int page, int maxItems) throws PatologyException {
		return null;
	}
	
	@Override
	protected ContactDto convertDomainToDto(ContactDomain domain) throws PatologyException {
		final ContactDto contact = new ContactDto();
		contact.setId(domain.getId());
		contact.setName(domain.getName());
		contact.setMessage(domain.getMessage());
		contact.setSubject(domain.getSubject());
		contact.setPhone(domain.getPhone());
		contact.setEmail(domain.getEmail());
		return contact;
	}

	@Override
	protected ContactDomain convertDtoToDomain(ContactDto dto) throws PatologyException {
		final ContactDomain contact = new ContactDomain();
		contact.setId(dto.getId());
		contact.setName(dto.getName());
		contact.setMessage(dto.getMessage());
		contact.setSubject(dto.getSubject());
		contact.setPhone(dto.getPhone());
		contact.setEmail(dto.getEmail());
		return contact;
	}
	
	public ContactDto sent(ContactDto contactDto) throws PatologyException {
		System.out.println("mensaje" + contactDto.getMessage());
		System.out.println("mensaje" + contactDto.getSubject());
		System.out.println("mensaje" + contactDto.getName());
		LaboratoryDomain laboratory = laboratoryDao.getById(1);
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
					+ "<br/><p>El usuario  <strong>" +  contactDto.getName() + "</strong> "
					+ "ha realizado una consulta sobre el Sistema desarrollado en la materia Sistemas Distribuidos - 2016 "
					+ "para el laboratorio Patol&oacute;gico de Encarnaci&oacute;n. El mismo es el siguiente:</p>"
					+ "<br/><p style=\"padding-left:5%;border: 1px solid #e1e1e8;background-color: #f7f7f9;\">"
					+ "<strong>Mensaje:</strong> " + contactDto.getMessage() + "</p>"
					+ "<br/><p>Sus datos de contacto son: </p>"
					+ "<p style=\"padding-left:5%;\">Tel&eacute;fono: " + contactDto.getPhone() + "</p>"
					+ "<p style=\"padding-left:5%;\">Email: " + contactDto.getEmail() + "</p>"
					+ "<br/><p>Atentamente</p>"
					+ "<br/><br/><p style=\"color: blue; font-weight: bold;\">Laboratorio de " + laboratory.getName() + "</p>" 
					+ "<p>Tel&eacute;fono: " + laboratory.getPhone() + "</p>"
					+ "<p>Direcci&oacute;n: " + laboratory.getAddress() + "</p>"
					+ "<p>Email: " + laboratory.getEmail() + "</p>"
					+ "<br/><br/><p style=\"color: red\">Este correo fue autogenerado, favor no responder </p>";
			
			System.out.println(text);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("fa.talavera95@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("taniamonges@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abel.oalex@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("jorgeesquivelfernandez@gmail.com"));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("diazpany@gmail.com"));
			
			message.setSubject("Contacto: " + contactDto.getSubject());
			message.setContent(text, "text/html; charset=utf-8");
			Transport.send(message);

		} catch (MessagingException e) {
			throw new PatologyException("envio mail fallo", e);
		} 
		return contactDto;
	}
	

}