package com.sandro.ecommercebackendspring.policy.controller;

import com.sandro.ecommercebackendspring.policy.service.PolicyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PolicyController {

    private final PolicyService policyService;

    @GetMapping("/privacy-policy")
    public ResponseEntity<?> getPrivacyPolicy() {
        return ResponseEntity.ok(policyService.getLastPrivacyPolicy());
    }

    @GetMapping("/terms-conditions")
    public ResponseEntity<?> getTermsAndConditions() {
        return ResponseEntity.ok(policyService.getLastTermsConditionsPolicy());
    }

    @GetMapping("/refund-policy")
    public ResponseEntity<?> getRefundPolicy() {
        return ResponseEntity.ok(policyService.getLastRefundPolicy());
    }

    @GetMapping("/shipping-return")
    public ResponseEntity<?> getShippingAndReturnPolicy() {
        return ResponseEntity.ok(policyService.getLastShippingReturnPolicy());
    }

    @GetMapping("/cookie-policy")
    public ResponseEntity<?> getCookiePolicy() {
        return ResponseEntity.ok(policyService.getLastCookiePolicy());
    }
}
