package com.sandro.ecommercebackendspring.wishlist;

import com.sandro.ecommercebackendspring.cart.Cart;
import com.sandro.ecommercebackendspring.cart.dto.AddToCartDTO;
import com.sandro.ecommercebackendspring.cart.dto.CartResponse;
import com.sandro.ecommercebackendspring.color.Color;
import com.sandro.ecommercebackendspring.color.ColorRepository;
import com.sandro.ecommercebackendspring.product.Product;
import com.sandro.ecommercebackendspring.product.ProductRepository;
import com.sandro.ecommercebackendspring.size.Size;
import com.sandro.ecommercebackendspring.size.SizeRepository;
import com.sandro.ecommercebackendspring.user.model.User;
import com.sandro.ecommercebackendspring.user.repository.UserRepository;
import com.sandro.ecommercebackendspring.wishlist.dto.AddToWishlistDTO;
import com.sandro.ecommercebackendspring.wishlist.dto.SyncToWishlistDTO;
import com.sandro.ecommercebackendspring.wishlist.dto.SyncWishlistDTO;
import com.sandro.ecommercebackendspring.wishlist.dto.WishlistResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
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

    public void syncWishlistForUser(SyncWishlistDTO request) {
        User user = getCurrentUser();

        for (SyncToWishlistDTO wishlistItem : request.getWishlist()) {

            Product product = productRepository.findById(wishlistItem.getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            Size size = wishlistItem.getSizeId() != null ? sizeRepository.findById(wishlistItem.getSizeId())
                    .orElse(null) : null;

            Color color = wishlistItem.getColorId() != null ? colorRepository.findById(wishlistItem.getColorId())
                    .orElse(null) : null;

            Optional<Wishlist> existingWishlistItem = wishlistRepository.findByUserAndProductAndSizeAndColor(
                    user, product, size, color
            );

            Wishlist userWishlistItem;
            if (existingWishlistItem.isPresent()) {
                userWishlistItem = existingWishlistItem.get();
            } else {
                userWishlistItem = new Wishlist();
                userWishlistItem.setUser(user);
                userWishlistItem.setProduct(product);
                userWishlistItem.setSize(size);
                userWishlistItem.setColor(color);
                wishlistRepository.save(userWishlistItem);
            }

            Set<Long> colorIds = wishlistItem.getColors().stream()
                    .map(Color::getId)
                    .collect(Collectors.toSet());

            List<Color> colorList = colorRepository.findAllById(colorIds);
            Set<Color> colors = new HashSet<>(colorList);
            userWishlistItem.setColors(colors);

            wishlistRepository.save(userWishlistItem);
        }
    }

    public List<WishlistResponse> getWishlistForUser() {
        User user = getCurrentUser();
        List<Wishlist> wishlistItems = wishlistRepository.findByUser(user);

        return wishlistItems.stream().map(cart -> {
            WishlistResponse response = new WishlistResponse();
            response.setId(cart.getId());
            response.setUserId(cart.getUser().getId());
            response.setProductId(cart.getProduct().getId());
            response.setSizeId(cart.getSize().getId());
            response.setColorId(cart.getColor().getId());
//            response.setQuantity(cart.getQuantity());
            response.setProduct(cart.getProduct());
            response.setColor(cart.getColor());
            response.setSize(cart.getSize());

            return response;
        }).collect(Collectors.toList());
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
