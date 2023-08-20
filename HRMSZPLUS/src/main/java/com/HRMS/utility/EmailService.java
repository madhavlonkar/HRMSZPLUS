package com.HRMS.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService{

	@Autowired
	private JavaMailSender mailSender;

	private static final Logger log = LoggerFactory.getLogger(EmailService.class);

	public void sendEmailWithOtp(String toEmail, int otp) {

		try {
			MimeMessage message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);

			helper.setFrom("nanduchavan2232@gmail.com");
			helper.setTo(toEmail);
			helper.setSubject("Login OTP For HRMS System");
			helper.setText("Please Use This OTP To Get Logged In:" + otp + "\nI will Be Expired Within 5 Min", true); // 'true'
																														// enables
																														// HTML
																														// content

			// Add the attachment
//            File attachment = new File(attachmentPath);
//            helper.addAttachment(attachment.getName(), attachment);

			mailSender.send(message);
			log.info("Mail Sent Successfully");

		} catch (Exception e) {
			e.printStackTrace();
			log.error("Unable to Send Mail");
		}
	}
}
