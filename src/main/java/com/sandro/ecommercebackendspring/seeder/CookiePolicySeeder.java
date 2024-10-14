package com.sandro.ecommercebackendspring.seeder;

import com.sandro.ecommercebackendspring.policy.model.CookiePolicy;
import com.sandro.ecommercebackendspring.policy.repository.CookiePolicyRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CookiePolicySeeder {

    private final CookiePolicyRepository cookiePolicyRepository;

    @PostConstruct
    public void seedPrivacyPolicy() {
        if (cookiePolicyRepository.count() == 0) {
            cookiePolicyRepository.save(new CookiePolicy("""
                    <h2>Privacy Policy</h2>
                    
                    <p>Last updated: March 09, 2023</p>
                    
                    <p>This Privacy Policy describes our policies and procedures on the collection, use, and disclosure of your information when you use our Service. It also explains your privacy rights and how the law protects you.</p>
                    
                    <p>We use your personal data to provide and improve the Service. By using the Service, you agree to the collection and use of information in accordance with this Privacy Policy.</p>
                    
                    <h3>Definitions</h3>
                    
                    <ul>
                      <li><strong>Account</strong> - A unique account created for you to access our Service or parts of it.</li>
                      <li><strong>Company</strong> - Refers to Blueskytech, 268 St, South New York, United States.</li>
                      <li><strong>Cookies</strong> - Small files placed on your device by a website, containing browsing history and other details.</li>
                      <li><strong>Personal Data</strong> - Information that identifies an individual, such as email address, name, and usage data.</li>
                      <li><strong>Service</strong> - Refers to the website Umino, accessible from <a href="https://blueskytechmage.com/gota/">https://blueskytechmage.com/gota/</a>.</li>
                    </ul>
                    
                    <h3>Personal Data Collection</h3>
                    
                    <p>We may ask for personal information including:</p>
                    
                    <ul>
                      <li>Email address</li>
                      <li>First and last name</li>
                      <li>Address, ZIP/Postal code, City</li>
                      <li>Usage data (automatically collected during Service use)</li>
                    </ul>
                    
                    <h3>Use of Your Personal Data</h3>
                    
                    <p>We use your personal data for the following purposes:</p>
                    
                    <ul>
                      <li>To provide and maintain our Service.</li>
                      <li>To manage your Account and registration.</li>
                      <li>For the performance of a contract, including purchases.</li>
                      <li>To contact you via email, phone, or mobile app notifications.</li>
                    </ul>
                    
                    <h3>Cookies</h3>
                    
                    <p>We use cookies to track your activity on our website and store certain information. You can control cookies through your browser settings. For more information, see our full Cookies Policy.</p>
                    
                    <h3>Changes to Privacy Policy</h3>
                    
                    <p>We may update this Privacy Policy from time to time. Check this page periodically for changes. Updates are effective upon posting.</p>
                    
                    """));
        }
    }
}
