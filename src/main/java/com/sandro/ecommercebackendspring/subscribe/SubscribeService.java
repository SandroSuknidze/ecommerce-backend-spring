package com.sandro.ecommercebackendspring.subscribe;

import com.sandro.ecommercebackendspring.exceptions.EmailSendingException;
import com.sandro.ecommercebackendspring.user.service.SendEmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;
    private final SendEmailService sendEmailService;

    public void createSubscription(SubscribeDTO request) {

        boolean userExists = subscribeRepository.existsByEmail(request.getEmail());
        if (userExists) {
            throw new UserAlreadySubscribedException("You are already subscribed");
        }

        Subscribe subscribe = new Subscribe();
        subscribe.setEmail(request.getEmail());

        subscribeRepository.save(subscribe);

        try {
            sendEmailService.sendSubscribeEmail(request.getEmail(), "Thank You for Subscribing!");
        } catch (MessagingException e) {
            log.error("Failed to send thanks subscribe email: {}", request.getEmail(), e);
            throw new EmailSendingException("Failed to send thanks subscribe.", e);
        }
    }
}
