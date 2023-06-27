package com.service;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class MailService {
	
	public void sendMailForError(String email, Throwable  e) {

		final String from = "ritukapadiya2002@gmail.com";// from address, company email
		final String appPassword = "kzpdmkzfjpuqoynz"; // from "app password" in google

		Properties prop = System.getProperties();

		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.ssl.enable", "false");

		Session session = Session.getInstance(prop, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, appPassword);
			}
		});

		session.setDebug(true);

		try {
			MimeMessage message = new MimeMessage(session);

			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
			message.setSubject("Client Got an Error ");
			message.setContent("Excetpion => "+e.getClass()+"<br>"+"Message => "+e.getMessage()+"<br> StackTrac:=> "+e.getStackTrace(), "text/html");

			Transport.send(message);

			System.out.println("email sent.............");
		} catch (Exception ee) {
			ee.printStackTrace();
			System.out.println("something went wrong...........");
		}
	}
}
