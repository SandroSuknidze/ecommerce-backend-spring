package com.sandro.ecommercebackendspring.order;

import com.sandro.ecommercebackendspring.user.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    @EntityGraph(attributePaths = {"product", "size", "color"})
    List<Order> findByUser(User user);
}
