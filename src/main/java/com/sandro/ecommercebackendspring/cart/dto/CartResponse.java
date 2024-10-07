package com.sandro.ecommercebackendspring.cart.dto;

import com.sandro.ecommercebackendspring.color.Color;
import com.sandro.ecommercebackendspring.product.Product;
import com.sandro.ecommercebackendspring.size.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartResponse {
    private Long id;
    private Long userId;
    private Long productId;
    private Long sizeId;
    private Long colorId;
    private int quantity;
    private Product product;
    private Color color;
    private Size size;
}
