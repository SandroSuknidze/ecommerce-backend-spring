package com.sandro.ecommercebackendspring.cart.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SyncCartDTO {

    @NotNull
    private List<AddToCartDTO> cart;


}
