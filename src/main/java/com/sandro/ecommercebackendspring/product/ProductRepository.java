package com.sandro.ecommercebackendspring.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT DISTINCT p FROM Product p " +
            "LEFT JOIN FETCH p.category " +
            "LEFT JOIN FETCH p.brand " +
            "LEFT JOIN FETCH p.colors " +  // Ensure you're fetching colors
            "WHERE p.category.id = :categoryId " +
            "AND p.stockQuantity > 0 " +
            "ORDER BY p.createdAt DESC")
    List<Product> findProductsByCategory(@Param("categoryId") Long categoryId);







}