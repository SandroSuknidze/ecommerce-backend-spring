package com.sandro.ecommercebackendspring.cart;

import com.sandro.ecommercebackendspring.product.Product;
import com.sandro.ecommercebackendspring.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUserAndProductAndSizeIdAndColorId(User user, Product product, Long sizeId, Long colorId);
}
