package com.sandro.ecommercebackendspring.cart;

import com.sandro.ecommercebackendspring.cart.dto.AddToCartDTO;
import com.sandro.ecommercebackendspring.cart.dto.CartResponse;
import com.sandro.ecommercebackendspring.cart.dto.RemoveFromCartDTO;
import com.sandro.ecommercebackendspring.cart.dto.SyncCartDTO;
import com.sandro.ecommercebackendspring.color.Color;
import com.sandro.ecommercebackendspring.color.ColorRepository;
import com.sandro.ecommercebackendspring.product.Product;
import com.sandro.ecommercebackendspring.product.ProductRepository;
import com.sandro.ecommercebackendspring.size.Size;
import com.sandro.ecommercebackendspring.size.SizeRepository;
import com.sandro.ecommercebackendspring.user.model.User;
import com.sandro.ecommercebackendspring.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Slf4j
@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final ColorRepository colorRepository;
    private final SizeRepository sizeRepository;

    public void addToCart(AddToCartDTO request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User user = getCurrentUser();

        Optional<Cart> existingCart = cartRepository.findByUserAndProductAndSizeIdAndColorId(
                user, product, request.getSizeId(), request.getColorId());


        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
            cart.setQuantity(cart.getQuantity() + request.getQuantity());
            cartRepository.save(cart);
        } else {
            Color color = null;
            if (request.getColorId() != null) {
                color = colorRepository.findById(request.getColorId())
                        .orElseThrow(() -> new RuntimeException("Color not found"));
            }

            Size size = null;
            if (request.getSizeId() != null) {
                size = sizeRepository.findById(request.getSizeId())
                        .orElseThrow(() -> new RuntimeException("Size not found"));
            }

            Cart cart = new Cart();
            cart.setProduct(product);
            cart.setUser(user);
            cart.setQuantity(request.getQuantity());
            cart.setColor(color);
            cart.setSize(size);

            cartRepository.save(cart);
        }
    }

    public void removeFromCart(RemoveFromCartDTO request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User user = getCurrentUser();

        Optional<Cart> existingCart = cartRepository.findByUserAndProductAndSizeIdAndColorId(
                user, product, request.getSizeId(), request.getColorId()
        );

        existingCart.ifPresent(cartRepository::delete);
    }

    // DTO here is the same
    public void updateQuantity(AddToCartDTO request) {
        Product product = productRepository.findById(request.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        User user = getCurrentUser();

        Optional<Cart> existingCart = cartRepository.findByUserAndProductAndSizeIdAndColorId(
                user, product, request.getSizeId(), request.getColorId());

        if (existingCart.isPresent()) {
            Cart cart = existingCart.get();
            cart.setQuantity(request.getQuantity());
            cartRepository.save(cart);
        } else {
            throw new RuntimeException("Cart not found");
        }
    }

    @Transactional
    public void clearCartForUser() {
        User user = getCurrentUser();
        cartRepository.deleteByUserId(user.getId());
    }

    public void syncCartForUser(SyncCartDTO request) {
        User user = getCurrentUser();

        for (AddToCartDTO cartItem : request.getCart()) {
            Product product = productRepository.findById(cartItem.getId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            Size size = cartItem.getSizeId() != null ? sizeRepository.findById(cartItem.getSizeId())
                    .orElse(null) : null;

            Color color = cartItem.getColorId() != null ? colorRepository.findById(cartItem.getColorId())
                    .orElse(null) : null;

            Optional<Cart> existingCart = cartRepository.findByUserAndProductAndSizeAndColor(
                    user, product, size, color
            );

            if (existingCart.isPresent()) {
                Cart cart = existingCart.get();
                cart.setQuantity(cart.getQuantity() + cartItem.getQuantity());
                cartRepository.save(cart);
            } else {
                Cart newCart = new Cart();
                newCart.setUser(user);
                newCart.setProduct(product);
                newCart.setQuantity(cartItem.getQuantity());
                newCart.setSize(size);
                newCart.setColor(color);
                cartRepository.save(newCart);
            }
        }
    }

    public List<CartResponse> getCartForUser() {
        User user = getCurrentUser();
        List<Cart> cartItems = cartRepository.findByUser(user);

        return cartItems.stream().map(cart -> {
            CartResponse response = new CartResponse();
            response.setId(cart.getId());
            response.setUserId(cart.getUser().getId());
            response.setProductId(cart.getProduct().getId());
            response.setSizeId(cart.getSize().getId());
            response.setColorId(cart.getColor().getId());
            response.setQuantity(cart.getQuantity());
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
