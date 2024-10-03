package com.sandro.ecommercebackendspring.product;


import com.sandro.ecommercebackendspring.color.Color;
import com.sandro.ecommercebackendspring.size.Size;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<Product> getAllSaleProducts() {
        return productRepository.findBySalePriceIsNotNull();
    }

    public List<Product> getRandomProducts() {
        return productRepository.findRandomProducts(4);
    }

    public List<Product> getFilteredProducts(Long categoryId, String brands, String colors, String sizes, String price) {
        return productRepository.findAll((root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();

            // Filter by category
            if (categoryId != null) {
                predicates.add(criteriaBuilder.equal(root.get("category").get("id"), categoryId));
            }

            // Filter by stock_quantity > 0
            predicates.add(criteriaBuilder.greaterThan(root.get("stockQuantity"), 0));

            // Filter by brands
            if (brands != null && !brands.isEmpty()) {
                List<Long> brandIds = Arrays.stream(brands.split(","))
                        .map(Long::parseLong)
                        .collect(Collectors.toList());
                predicates.add(root.get("brand").get("id").in(brandIds));
            }

            // Filter by colors (assuming a ManyToMany relationship)
            if (colors != null && !colors.isEmpty()) {
                List<Long> colorIds = Arrays.stream(colors.split(","))
                        .map(Long::parseLong)
                        .collect(Collectors.toList());
                Join<Product, Color> colorJoin = root.join("colors");
                predicates.add(colorJoin.get("id").in(colorIds));
            }

            // Filter by sizes (assuming a ManyToMany relationship)
            if (sizes != null && !sizes.isEmpty()) {
                List<Long> sizeIds = Arrays.stream(sizes.split(","))
                        .map(Long::parseLong)
                        .collect(Collectors.toList());
                Join<Product, Size> sizeJoin = root.join("sizes");
                predicates.add(sizeJoin.get("id").in(sizeIds));
            }

            // Filter by price range
            if (price != null && !price.isEmpty()) {
                String[] prices = price.split(",");
                if (prices.length == 2) {
                    float minPrice = Float.parseFloat(prices[0]);
                    float maxPrice = Float.parseFloat(prices[1]);

                    Predicate pricePredicate = criteriaBuilder.or(
                            criteriaBuilder.between(root.get("price"), minPrice, maxPrice),
                            criteriaBuilder.between(root.get("salePrice"), minPrice, maxPrice)
                    );
                    predicates.add(pricePredicate);
                }
            }

            query.orderBy(criteriaBuilder.desc(root.get("createdAt")));

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

}
