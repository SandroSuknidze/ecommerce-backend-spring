package com.sandro.ecommercebackendspring.wishlist;

import com.sandro.ecommercebackendspring.cart.Cart;
import com.sandro.ecommercebackendspring.color.Color;
import com.sandro.ecommercebackendspring.product.Product;
import com.sandro.ecommercebackendspring.size.Size;
import com.sandro.ecommercebackendspring.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Optional<Wishlist> findByUserAndProductId(User user, Long productId);

    Optional<Wishlist> findByUserAndProductAndSizeAndColor(User user, Product product, Size size, Color color);

    List<Wishlist> findByUser(User user);

}
