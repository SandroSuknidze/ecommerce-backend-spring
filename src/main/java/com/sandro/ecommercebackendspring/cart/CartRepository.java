package com.sandro.ecommercebackendspring.cart;

import com.sandro.ecommercebackendspring.color.Color;
import com.sandro.ecommercebackendspring.product.Product;
import com.sandro.ecommercebackendspring.size.Size;
import com.sandro.ecommercebackendspring.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    Optional<Cart> findByUserAndProductAndSizeIdAndColorId(User user, Product product, Long sizeId, Long colorId);

    void deleteByUserId(Long userId);

    Optional<Cart> findByUserAndProductAndSizeAndColor(User user, Product product, Size size, Color color);

    List<Cart> findByUser(User user);
}
