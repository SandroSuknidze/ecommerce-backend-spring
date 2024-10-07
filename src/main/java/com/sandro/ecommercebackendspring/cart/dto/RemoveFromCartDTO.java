package com.sandro.ecommercebackendspring.cart.dto;

import lombok.Getter;

@Getter
public class RemoveFromCartDTO {

    // This is a productId
    private Long id;
    private Long sizeId;
    private Long colorId;
}
