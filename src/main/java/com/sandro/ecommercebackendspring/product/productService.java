package com.sandro.ecommercebackendspring.product;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class productService {

    @GetMapping("/products")
    public String products() {
        return "Hello products";
    }
}
