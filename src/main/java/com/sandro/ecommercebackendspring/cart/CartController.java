package com.sandro.ecommercebackendspring.cart;

import com.sandro.ecommercebackendspring.cart.dto.AddToCartDTO;
import com.sandro.ecommercebackendspring.cart.dto.CartResponse;
import com.sandro.ecommercebackendspring.cart.dto.RemoveFromCartDTO;
import com.sandro.ecommercebackendspring.cart.dto.SyncCartDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PostMapping("/cart/remove")
    public ResponseEntity<?> removeFromCart(@Valid @RequestBody RemoveFromCartDTO request) {
        try {
            cartService.removeFromCart(request);
            return ResponseEntity.ok(Map.of("message", "Item removed successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/cart/update-quantity")
    public ResponseEntity<?> updateQuantityCart(@Valid @RequestBody AddToCartDTO request) {
        try {
            cartService.updateQuantity(request);
            return ResponseEntity.ok(Map.of("message", "Quantity updated"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/cart/clear")
    public ResponseEntity<?> clearCart() {
        try {
            cartService.clearCartForUser();
            return ResponseEntity.ok(Map.of("message", "Cart cleared successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/cart/sync")
    public ResponseEntity<?> syncCart(@Valid @RequestBody SyncCartDTO request) {
        try {
            cartService.syncCartForUser(request);
            return ResponseEntity.ok(Map.of("message", "Cart synchronized"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/cart")
    public ResponseEntity<List<CartResponse>> getCartForUser() {
        List<CartResponse> cart = cartService.getCartForUser();
        return ResponseEntity.ok(cart);
    }
}
