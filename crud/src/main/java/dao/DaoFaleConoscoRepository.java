package dao;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import models.FaleConosco;

public class DaoFaleConoscoRepository {
	private FaleConosco faleConosco;

	public DaoFaleConoscoRepository(FaleConosco faleConosco) {
		setFaleConosco(faleConosco);
	}
	
	public boolean enviarEmail() {
		
		boolean enviou = false;
	    Properties properties = new Properties();
	    properties.put("mail.smtp.host", "smtp.gmail.com");
	    properties.put("mail.smtp.port", "587");
	    properties.put("mail.smtp.auth", "true");
	    properties.put("mail.smtp.starttls.enable", "true");

	    // credenciais invalidas
	    String usuario = "teste@gmail.com";
	    String senha = "teste";

	    Session session = Session.getInstance(properties, new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(usuario, senha);
	        }
	    });

	    try {
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(usuario));
	        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(faleConosco.getEmail()));
	        message.setSubject(faleConosco.getAssunto());
	        message.setText(faleConosco.getMensagem());

	        Transport.send(message);
	        enviou = true;
	    } catch (MessagingException e) {
	        e.printStackTrace();
	    }
	    
	    return enviou;
	}
	
	public FaleConosco getFaleConosco() {
		return faleConosco;
	}

	public void setFaleConosco(FaleConosco faleConosco) {
		this.faleConosco = faleConosco;
	}
	
}
