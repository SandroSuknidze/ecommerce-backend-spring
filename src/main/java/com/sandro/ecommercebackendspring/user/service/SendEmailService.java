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

    @Async
    public void sendSubscribeEmail(String to, String subject) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        helper.setFrom("Umino <" + from + ">");
        helper.setTo(to);
        helper.setSubject(subject);

        String body = buildThankYouEmail();

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

    public String buildThankYouEmail() {
        return "<!DOCTYPE html>" +
                "<html lang=\"en\">" +
                "<head>" +
                "<meta charset=\"UTF-8\">" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">" +
                "<title>Thank You for Subscribing!</title>" +
                "<style>" +
                "body { font-family: Arial, sans-serif; background-color: #f0f0f0; text-align: center; padding: 50px; }" +
                ".container { max-width: 600px; margin: 0 auto; background-color: #fff; padding: 30px; border-radius: 8px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); }" +
                "h1 { color: #333; margin-bottom: 20px; }" +
                "p { color: #666; font-size: 18px; line-height: 1.6; }" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class=\"container\">" +
                "<h1>Thank You for Subscribing!</h1>" +
                "<p>We appreciate you joining our newsletter. You'll now receive updates and exclusive offers straight to your inbox.</p>" +
                "</div>" +
                "</body>" +
                "</html>";
    }
}
