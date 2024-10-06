package com.sandro.ecommercebackendspring.policy.repository;

import com.sandro.ecommercebackendspring.policy.model.ShippingReturn;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ShippingReturnRepository extends JpaRepository<ShippingReturn, Long> {

    ShippingReturn findTopByOrderByIdDesc();
}
