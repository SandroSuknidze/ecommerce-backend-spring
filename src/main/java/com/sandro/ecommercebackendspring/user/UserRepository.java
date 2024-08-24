package com.sandro.ecommercebackendspring.user;

import com.sandro.ecommercebackendspring.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
