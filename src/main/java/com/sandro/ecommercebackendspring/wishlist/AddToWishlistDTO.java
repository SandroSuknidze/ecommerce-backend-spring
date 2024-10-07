package com.sandro.ecommercebackendspring.wishlist;

import com.sandro.ecommercebackendspring.color.Color;
import lombok.Getter;
import lombok.ToString;

import java.util.Set;

@Getter
@ToString
public class AddToWishlistDTO {

    // This is a productId
    private Long id;
    private Set<Color> colors;
    private Long sizeId;
    private Long colorId;
}
