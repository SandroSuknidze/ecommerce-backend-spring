package com.sandro.ecommercebackendspring.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {


    @Query("SELECT p FROM Product p " +
            "WHERE p.category.id = :categoryId " +
            "AND p.stockQuantity > 0 " +
            "ORDER BY p.createdAt DESC")
    List<Product> findProductsByCategory(@Param("categoryId") Long categoryId);

    @Query("SELECT p FROM Product p WHERE p.createdAt >= :startDate AND p.stockQuantity > 0")
    List<Product> findProductsArrivedLast30Days(@Param("startDate") LocalDateTime startDate);

    @Query("SELECT p FROM Product p Where p.isFeatured = true AND p.stockQuantity > 0")
    List<Product> findProductsFeatured();

    List<Product> findBySalePriceIsNotNull();

    @Query(value = "SELECT * FROM products ORDER BY RAND() LIMIT :count", nativeQuery = true)
    List<Product> findRandomProducts(@Param("count") int count);

    List<Product> findProductsByTitleContaining(String q);

    Product findProductByIdAndStockQuantityGreaterThan(Long id, int stockQuantity);
}