package com.sandro.ecommercebackendspring.user.service;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    @Async
    public void sendEmail(String to, String subject, String resetLink) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("Umino <" + from + ">");
        helper.setTo(to);
        helper.setSubject(subject);

        String body = buildEmailBody(resetLink);

        helper.setText(body, true);
        javaMailSender.send(mimeMessage);
    }

    public String buildEmailBody(String resetLink) {
        return "<html>" +
                "<body style='font-family: Arial, sans-serif; background-color: #f4f4f4; margin: 0; padding: 20px;'>" +
                "<div style='max-width: 600px; margin: 0 auto; background-color: #fff; padding: 20px; border-radius: 8px; box-shadow: 0 0 10px rgba(0,0,0,0.1);'>" +
                "<h1 style='color: #4287f5; text-align: center;'>Password Reset Request</h1>" +
                "<p>Hi there,</p>" +
                "<p>We received a request to reset your password. Click the button below to reset it:</p>" +
                "<div style='text-align: center; margin: 20px 0;'>" +
                "<a href='" + resetLink + "' style='background-color: #4287f5; color: white; padding: 10px 20px; text-decoration: none; border-radius: 5px;'>Reset Password</a>" +
                "</div>" +
                "<p>If you did not request this, please ignore this email. Your password will remain the same.</p>" +
                "<p>Thank you,<br>The Support Team</p>" +
                "</div>" +
                "<footer style='text-align: center; margin-top: 20px;'>" +
                "</footer>" +
                "</body>" +
                "</html>";
    }
}