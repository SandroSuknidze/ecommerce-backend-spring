package com.sandro.ecommercebackendspring.seeder;

import com.sandro.ecommercebackendspring.policy.model.TermsConditions;
import com.sandro.ecommercebackendspring.policy.repository.TermsConditionsRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TermsConditionsSeeder {

    private final TermsConditionsRepository termsConditionsRepository;

    @PostConstruct
    public void seedTermsConditions() {
        if (termsConditionsRepository.count() == 0) {
            termsConditionsRepository.save(new TermsConditions("""
                    <h2>Terms & Conditions</h2>
                    
                    <p>Last updated: March 09, 2023</p>
                    
                    <h3>Introduction</h3>
                    
                    <p>These Terms & Conditions govern your use of our website located at <a href="https://blueskytechmage.com/gota/">https://blueskytechmage.com/gota/</a> and the services we offer. By accessing or using the Service, you agree to be bound by these Terms.</p>
                    
                    <h3>Use of Service</h3>
                    
                    <p>You agree to use the Service for lawful purposes and in accordance with these Terms. You are responsible for all activities under your account, including maintaining confidentiality of your login credentials.</p>
                    
                    <h3>Purchases</h3>
                    
                    <p>If you wish to purchase any product or service, you may be asked to supply certain information relevant to your purchase, including your payment method and billing information. You agree that all information provided is accurate and complete.</p>
                    
                    <h3>Intellectual Property</h3>
                    
                    <p>All content on the Service, including text, graphics, logos, and images, is owned by the Company or its licensors. Unauthorized use of the content is prohibited.</p>
                    
                    <h3>Termination</h3>
                    
                    <p>We reserve the right to suspend or terminate your account if you violate any of the Terms & Conditions.</p>
                    
                    <h3>Changes to Terms</h3>
                    
                    <p>We reserve the right to modify these Terms & Conditions at any time. Changes will be effective when posted on this page.</p>
                    
                    """));
        }
    }
}
