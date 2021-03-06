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
			String text = "<!DOCTYPE html><html lang=\"es\"><head><title>Bootstrap Example</title>"
					+ "<meta charset=\"utf-8\"><meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">"
					+ "<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">"
					+ "<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js\"></script>"
					+ "<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>"
					+ "<style> .grey-color {background-color: #eee} .white-color {background-color: #fff; width: 50%;} .center {text-align: center; margin-left: auto; margin-right: auto; margin-bottom: auto; margin-top: auto;} </style>"
					+ "</head><body>" 
					+ "<div class=\"container grey-color\">"
				  	+ "<div class=\"row\"><div class=\"span12\"><div class=\"hero-unit center\">"
				    + "<br><br><h1>Grupo de Sistemas de Distribuidos 2016</h1><br/>"
				    + "<p>El usuario <b>" + contactDto.getName() + "</b> ha realizado la siguiente consulta:"
				    + "<div class=\"container white-color center\">"
					+ "<blockquote><br><p>\"" + contactDto.getMessage() + "\"</p>"
					+ "<footer>" + contactDto.getName() + "<em><br>Tel&eacute;fono: " + contactDto.getPhone() + "<br>Email: "+ contactDto.getEmail() + "</em></footer>"
					+ "<br></blockquote></div>"
				    + "<br><address>"
				    + "<strong>Laboratorio de " + laboratory.getName() + "</strong><br>" + laboratory.getAddress() + "<br>"
				    + "Encarnaci&oacute;n<br>"
				    + "<abbr title=\"Phone\">Telefono: </abbr>" + laboratory.getPhone()
				    + "<abbr title=\"Email\">, Email: </abbr>" + laboratory.getEmail()
				    + "</address><br>"
				    + "<span class=\"label label-warning\"><span class=\"glyphicon glyphicon-info-sign\" aria-hidden=\"true\"></span>  Favor no responder a este correo </span>"
				    + "<br></div></div><br/></div></body></html>";
			
			System.out.println(text);
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			InternetAddress[] mailTo = {
					new InternetAddress("jorgeesquivelfernandez@gmail.com"),
					new InternetAddress("fa.talavera95@gmail.com"),
					new InternetAddress("taniamonges@gmail.com"),
					new InternetAddress("abel.oalex@gmail.com"),
					new InternetAddress("diazpany@gmail.com")
			};
			message.setRecipients(Message.RecipientType.TO, mailTo);
			
			message.setSubject("Contacto: " + contactDto.getSubject());
			message.setContent(text, "text/html; charset=utf-8");
			Transport.send(message);

		} catch (MessagingException e) {
			throw new PatologyException("envio mail fallo", e);
		} 
		return contactDto;
	}
	

}