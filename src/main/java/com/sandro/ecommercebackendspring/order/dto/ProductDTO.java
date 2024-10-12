package com.sandro.ecommercebackendspring.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
public class ProductDTO {

    private Long id;
    private Long categoryId;
    private Long brandId;
    private String title;
    private String description;
    private List<String> imagePath;
    private BigDecimal price;
    private BigDecimal salePrice;
    private Float rating;
    private int stockQuantity;
    private boolean isFeatured;
    private String createdAt;
    private String updatedAt;
}
