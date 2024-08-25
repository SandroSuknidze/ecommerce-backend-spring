package com.sandro.ecommercebackendspring.user.repository;

import com.sandro.ecommercebackendspring.user.model.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    void deleteByUserId(Long userId);
}
