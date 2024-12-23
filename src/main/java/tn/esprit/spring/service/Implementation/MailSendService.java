
package tn.esprit.spring.service.Implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class MailSendService {
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	@Async
	public void sendEmail(String toEmail,String body,String subject) {
			SimpleMailMessage message = new SimpleMailMessage();

			message.setFrom("oibysmicroassurancegmail.com");
			message.setTo(toEmail);
			message.setText(body);
			message.setSubject(subject);

			javaMailSender.send(message);
			System.out.println("Mail Send ...");}
}
