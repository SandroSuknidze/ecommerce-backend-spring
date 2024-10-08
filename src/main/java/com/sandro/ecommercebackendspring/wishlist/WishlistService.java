package com.sandro.ecommercebackendspring.wishlist;

import com.sandro.ecommercebackendspring.color.Color;
import com.sandro.ecommercebackendspring.color.ColorRepository;
import com.sandro.ecommercebackendspring.product.Product;
import com.sandro.ecommercebackendspring.product.ProductRepository;
import com.sandro.ecommercebackendspring.size.Size;
import com.sandro.ecommercebackendspring.size.SizeRepository;
import com.sandro.ecommercebackendspring.user.model.User;
import com.sandro.ecommercebackendspring.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ColorRepository colorRepository;
    private final SizeRepository sizeRepository;

    public void addWishlistItem(AddToWishlistDTO request) {
        User user = getCurrentUser();

        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));

        Size size = null;
        if (request.getSizeId() != null) {
            size = sizeRepository.findById(request.getSizeId())
                    .orElseThrow(() -> new IllegalArgumentException("Size not found"));
        }

        Color color = null;
        if (request.getColorId() != null) {
            color = colorRepository.findById(request.getColorId())
                    .orElseThrow(() -> new IllegalArgumentException("Color not found"));
        }

        Set<Color> colors = request.getColors().stream()
                .map(colorDto -> colorRepository.findById(colorDto.getId())
                        .orElseThrow(() -> new IllegalArgumentException("Color not found")))
                .collect(Collectors.toSet());

        Wishlist wishlist = new Wishlist();
        wishlist.setUser(user);
        wishlist.setProduct(product);
        wishlist.setSize(size);
        wishlist.setColors(colors);
        wishlist.setColor(color);

        wishlistRepository.save(wishlist);
    }

    public void removeWishlistItem(Long productId) {
        User user = getCurrentUser();
        Wishlist wishlist = wishlistRepository.findByUserAndProductId(user, productId)
                .orElseThrow(() -> new RuntimeException("Wishlist item not found"));

        wishlistRepository.delete(wishlist);
    }

    private User getCurrentUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new RuntimeException("User not found");
        } else {
            return user;
        }
    }
}
