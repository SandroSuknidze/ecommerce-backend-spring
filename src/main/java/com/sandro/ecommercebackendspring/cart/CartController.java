package com.sandro.ecommercebackendspring.cart;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Slf4j
public class CartController {

    private final CartService cartService;

    @PostMapping("/cart/add")
    public ResponseEntity<?> addToCart(@Valid @RequestBody AddToCartDTO request) {
        try {
            cartService.addToCart(request);
            return ResponseEntity.ok(Map.of("message", "Product added to cart successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
