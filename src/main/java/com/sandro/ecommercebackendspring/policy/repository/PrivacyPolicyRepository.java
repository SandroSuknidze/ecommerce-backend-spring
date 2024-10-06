package com.sandro.ecommercebackendspring.policy.repository;

import com.sandro.ecommercebackendspring.policy.model.PrivacyPolicy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrivacyPolicyRepository extends JpaRepository<PrivacyPolicy, Long> {

    PrivacyPolicy findTopByOrderByIdDesc();
}
