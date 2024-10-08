package com.sandro.ecommercebackendspring.wishlist.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SyncWishlistDTO {

    @NotNull
    private List<SyncToWishlistDTO> wishlist;
}
