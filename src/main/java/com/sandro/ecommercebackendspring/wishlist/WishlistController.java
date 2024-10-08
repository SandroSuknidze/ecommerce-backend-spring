package com.sandro.ecommercebackendspring.wishlist;

import com.sandro.ecommercebackendspring.cart.dto.CartResponse;
import com.sandro.ecommercebackendspring.wishlist.dto.AddToWishlistDTO;
import com.sandro.ecommercebackendspring.wishlist.dto.SyncToWishlistDTO;
import com.sandro.ecommercebackendspring.wishlist.dto.SyncWishlistDTO;
import com.sandro.ecommercebackendspring.wishlist.dto.WishlistResponse;
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

    @PostMapping("/wishlist/sync")
    public ResponseEntity<?> syncWishlist(@Valid @RequestBody SyncWishlistDTO request) {
        try {
            wishlistService.syncWishlistForUser(request);
            return ResponseEntity.ok(Map.of("message", "Wishlist synchronized"));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/wishlist")
    public ResponseEntity<List<WishlistResponse>> getAllWishlist() {
        List<WishlistResponse> wishlist = wishlistService.getWishlistForUser();
        return ResponseEntity.ok(wishlist);
    }
}
