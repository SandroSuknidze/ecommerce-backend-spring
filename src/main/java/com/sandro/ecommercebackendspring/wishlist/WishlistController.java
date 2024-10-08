package com.sandro.ecommercebackendspring.wishlist;

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
public class WishlistController {

    private final WishlistService wishlistService;

    @PostMapping("/wishlist/add")
    public ResponseEntity<?> addWishlist(@Valid @RequestBody AddToWishlistDTO request) {
        try {
            wishlistService.addWishlistItem(request);
            return ResponseEntity.ok(Map.of("message", "Item added to wishlist"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/wishlist/remove")
    public ResponseEntity<?> removeWishlist(@RequestBody Map<String, String> request) {
        try {
            Long productId = Long.parseLong(request.get("id"));
            wishlistService.removeWishlistItem(productId);
            return ResponseEntity.ok(Map.of("message", "Item removed successfully"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
