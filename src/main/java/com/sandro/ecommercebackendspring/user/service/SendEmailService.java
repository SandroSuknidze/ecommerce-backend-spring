package com.sandro.ecommercebackendspring.user.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    @Autowired
    public SendEmailService(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    public void sendEmail(String to, String subject, String body) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        javaMailSender.send(message);
    }
}
