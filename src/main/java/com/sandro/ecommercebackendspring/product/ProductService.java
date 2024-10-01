package com.sandro.ecommercebackendspring.product;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> getProductsByCategory(Long categoryId) {
        return productRepository.findProductsByCategory(categoryId);
    }

    public List<Product> getNewArrivalProducts() {
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        return productRepository.findProductsArrivedLast30Days(thirtyDaysAgo);
    }

    public List<Product> getAllFeaturedProducts() {
        return productRepository.findProductsFeatured();
    }
}
