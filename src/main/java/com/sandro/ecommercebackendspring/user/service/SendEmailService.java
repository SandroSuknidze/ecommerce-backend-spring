package com.sandro.ecommercebackendspring.user.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SendEmailService {

    private final JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String from;

    // TODO: finish this method to send an email with body as html
    @Async
    public void sendEmail(String to, String subject) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);
        String body = "<html>" +
                "<body>" +
                "<h1 style='color: #4CAF50;'>Welcome to Our Service!</h1>" +
                "<p>We are excited to have you on board.</p>" +
                "<a href='https://yourwebsite.com'>Visit our website</a>" +
                "</body>" +
                "</html>";
        helper.setText(body, true);

        javaMailSender.send(mimeMessage);
    }
}
