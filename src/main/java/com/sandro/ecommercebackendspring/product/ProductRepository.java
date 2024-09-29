package com.sandro.ecommercebackendspring.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {


    @Query("SELECT DISTINCT p FROM Product p " +
            "LEFT JOIN FETCH p.category " +
            "LEFT JOIN FETCH p.brand " +
            "LEFT JOIN FETCH p.colors " +
            "WHERE p.category.id = :categoryId " +
            "AND p.stockQuantity > 0 " +
            "ORDER BY p.createdAt DESC")
    List<Product> findProductsByCategory(@Param("categoryId") Long categoryId);

    @Query("SELECT p FROM Product p WHERE p.createdAt >= :startDate")
    List<Product> findProductsArrivedLast30Days(@Param("startDate") LocalDateTime startDate);
}