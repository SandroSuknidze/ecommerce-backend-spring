package com.sandro.ecommercebackendspring.policy.repository;

import com.sandro.ecommercebackendspring.policy.model.TermsConditions;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TermsConditionsRepository extends JpaRepository<TermsConditions, Long> {

    TermsConditions findTopByOrderByIdDesc();
}
