package my.springboot.hello.controller;

import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailControler {

	private static final Logger logger = LoggerFactory
			.getLogger(EmailControler.class);

	@RequestMapping(value = "/sendemail")
	public String sendEmail()
			throws AddressException, MessagingException, IOException {
		logger.info("Sending mail");
		sendmail();
		return "Email sent successfully";
	}

	private void sendmail()
			throws AddressException, MessagingException, IOException {
		logger.info("Preparing mail message ....");
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		String address = "lolimepop@gmail.com";
		Session session = Session.getInstance(props,
				new javax.mail.Authenticator() {
					@Override
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication(address,
								"LoLipOpcDe37UjM");
					}
				});

		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(address, false));

		msg.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(address));
		msg.setSubject("Tutorials point email");
		msg.setContent("<i>Tutorials point email</i>", "text/html"); // why is
																		// this
																		// here
		msg.setSentDate(new Date());

		// attachments version
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("<h1>Tutorials point email as HTML</h1>",
				"text/html");

		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);

		// MimeBodyPart attachPart = new MimeBodyPart();
		// attachPart.attachFile("/var/tmp/image19.png");
		// multipart.addBodyPart(attachPart);
		msg.setContent(multipart); // any how new Content is added
		logger.info("Mail message prepared ....");
		Transport.send(msg);
		logger.info("Mail should be sent....");

	}
}
