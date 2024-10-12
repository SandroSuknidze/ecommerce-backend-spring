package com.sandro.ecommercebackendspring.order.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class OrderRequestDTO {

    private DataDTO data;

    @Getter
    @Setter
    @ToString
    public static class DataDTO {
        private String note;

        @NotBlank
        private String country;

        @NotBlank
        private String city;

        // This is an exception
        @JsonProperty("zipCode")
        @NotBlank
        private String zipCode;
    }
}
