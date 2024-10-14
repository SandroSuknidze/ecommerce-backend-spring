package com.sandro.ecommercebackendspring.seeder;

import com.sandro.ecommercebackendspring.policy.model.ShippingReturn;
import com.sandro.ecommercebackendspring.policy.repository.ShippingReturnRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ShippingReturnSeeder {

    private final ShippingReturnRepository shippingReturnRepository;

    @PostConstruct
    public void seedShippingReturn() {
        if (shippingReturnRepository.count() == 0) {
            shippingReturnRepository.save(new ShippingReturn("""
                    <h2>Shipping & Return Policy</h2>
                    
                    <p>Last updated: March 09, 2023</p>
                    
                    <h3>Shipping</h3>
                    
                    <p>We ship to addresses in the United States and internationally. Shipping fees and estimated delivery times depend on your location and the chosen shipping method. Orders are processed within 1-3 business days, excluding weekends and holidays.</p>
                    
                    <h3>Shipping Confirmation & Tracking</h3>
                    
                    <p>Once your order is shipped, you will receive a confirmation email containing tracking details. Please allow 24 hours for the tracking information to update.</p>
                    
                    <h3>Return Policy</h3>
                    
                    <p>You have 14 days from the delivery date to return your item for a refund. To be eligible for a return, your item must be unused, in its original packaging, and in the same condition that you received it. You are responsible for return shipping costs.</p>
                    
                    <h3>Non-Returnable Items</h3>
                    
                    <ul>
                      <li>Gift cards</li>
                      <li>Downloadable software products</li>
                      <li>Personal care items</li>
                    </ul>
                    
                    <h3>How to Return</h3>
                    
                    <p>To initiate a return, email us at returns@umino.com with your order number and reason for the return. We will provide you with instructions on how to proceed.</p>
                    
                    """));
        }
    }
}
