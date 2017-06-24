package com.other;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class Email {
	 private static final String HOST = "smtp.gmail.com";
	 private static final int PORT = 465;
	 private static final String FROM = "systempaymenthey@gmail.com";
	 private static final String PASSWORD = "systempayment";
	 private String to;
	 private String subject;
	 private String content;
	 private static final String PATH_FILE = "PotwierdzeniePrzelewu.pdf";
	 

	  
	 public Email(String to, String subject, String content) {
	
		this.to = to;
		this.subject = subject;
		this.content = content;
	
	}
	 
	
	 public boolean send() throws MessagingException {

		  Properties props = new Properties();
		  props.put("mail.transport.protocol", "smtps");
		  props.put("mail.smtps.auth", "true");

		  // Pobranie sesji
		 // Session mailSession = Session.getDefaultInstance(props, null);
		  Session mailSession = Session.getInstance(props,
			        new javax.mail.Authenticator() {
			           protected PasswordAuthentication getPasswordAuthentication() {
			              return new PasswordAuthentication(FROM, PASSWORD);
			           }
			        });
		  
		  // Tworzenie wiadomoœci
		  MimeMessage message = new MimeMessage(mailSession);
		  message.setSubject(subject);

		  // Stworzenie czêœci wiadomosci z treœci¹
		  MimeBodyPart textPart = new MimeBodyPart();
		  textPart.setContent(content, "text/html; charset=ISO-8859-2");

		  // Stworzenie czêœci z za³acznikami
		  MimeBodyPart attachFilePart = new MimeBodyPart();
		  FileDataSource fds = new FileDataSource(PATH_FILE);
		  attachFilePart.setDataHandler(new DataHandler(fds));
		  attachFilePart.setFileName(fds.getName());

		  // Zestawienie obydwu czêœci maila w jedn¹ wieloczêœciow¹
		  Multipart mp = new MimeMultipart();
		  mp.addBodyPart(textPart);
		  mp.addBodyPart(attachFilePart);

		  // Dodanie treœci maila
		  message.setContent(mp);
		  message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

		  Transport transport = mailSession.getTransport();
		  transport.connect(HOST, PORT, FROM, PASSWORD);

		  // Wys¹³nei maila
		  transport.sendMessage(message, message
		    .getRecipients(Message.RecipientType.TO));
		  transport.close();
		  return true;
		 }
	
	
	
	 
	 
}
