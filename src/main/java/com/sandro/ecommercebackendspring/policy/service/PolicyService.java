package com.sandro.ecommercebackendspring.policy.service;

import com.sandro.ecommercebackendspring.policy.model.*;
import com.sandro.ecommercebackendspring.policy.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PolicyService {

    private final CookiePolicyRepository cookiePolicyRepository;
    private final PrivacyPolicyRepository privacyPolicyRepository;
    private final RefundPolicyRepository refundPolicyRepository;
    private final ShippingReturnRepository shippingReturnRepository;
    private final TermsConditionsRepository termsConditionsRepository;


    public CookiePolicy getLastCookiePolicy() {
        return cookiePolicyRepository.findTopByOrderByIdDesc();
    }

    public PrivacyPolicy getLastPrivacyPolicy() {
        return privacyPolicyRepository.findTopByOrderByIdDesc();
    }

    public RefundPolicy getLastRefundPolicy() {
        return refundPolicyRepository.findTopByOrderByIdDesc();
    }

    public ShippingReturn getLastShippingReturnPolicy() {
        return shippingReturnRepository.findTopByOrderByIdDesc();
    }

    public TermsConditions getLastTermsConditionsPolicy() {
        return termsConditionsRepository.findTopByOrderByIdDesc();
    }
}
