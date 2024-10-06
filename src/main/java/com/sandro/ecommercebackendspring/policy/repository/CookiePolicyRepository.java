package com.sandro.ecommercebackendspring.policy.repository;

import com.sandro.ecommercebackendspring.policy.model.CookiePolicy;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CookiePolicyRepository extends JpaRepository<CookiePolicy, Long> {

    CookiePolicy findTopByOrderByIdDesc();
}
