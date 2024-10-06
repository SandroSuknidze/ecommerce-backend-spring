package com.sandro.ecommercebackendspring.cart;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class AddToCartDTO {

    // This is a productId
    private Long id;
    private Integer quantity;
    private Long sizeId;
    private Long colorId;
}
