package com.sandro.ecommercebackendspring.wishlist;

import com.sandro.ecommercebackendspring.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    Optional<Wishlist> findByUserAndProductId(User user, Long productId);
}
