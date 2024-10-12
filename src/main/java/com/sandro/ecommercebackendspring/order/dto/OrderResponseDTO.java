package com.sandro.ecommercebackendspring.order.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderResponseDTO {
    private Long id;
    private Long userId;
    private Long productId;
    private Long sizeId;
    private Long colorId;
    private int quantity;
    private BigDecimal totalPrice;
    private String note;
    private String country;
    private String city;
    private String zipCode;
    private String purchasedAt;
    private String createdAt;
    private ProductDTO product;
    private SizeDTO size;
    private ColorDTO color;
}
