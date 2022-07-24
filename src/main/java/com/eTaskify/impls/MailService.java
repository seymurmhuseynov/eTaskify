package com.eTaskify.impls;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailService {

    @Value("${spring.mail.username}")
    private String fromEmail;

    private final JavaMailSender mailSender;

    public MailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    void sendMail(String email){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText("Mail:");
        message.setSubject("subject");
        message.setFrom(fromEmail);
        message.setTo(email);
        mailSender.send(message);
    }



}
