package com.sandro.ecommercebackendspring.policy.repository;

import com.sandro.ecommercebackendspring.policy.model.RefundPolicy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface RefundPolicyRepository extends JpaRepository<RefundPolicy, Long> {

    RefundPolicy findTopByOrderByIdDesc();
}
