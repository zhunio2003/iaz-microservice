package com.mazr.iaz.microservices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazr.iaz.microservices.entity.EmailVerificationToken;
import com.mazr.iaz.microservices.entity.User;

public interface EmailVerificationTokenRepository extends JpaRepository<EmailVerificationToken, Long> {
    
    Optional<EmailVerificationToken> findByTokenAndIsUsedFalseAndIsExpiredFalse(String token);

    List<EmailVerificationToken> findByUser(User user);

    List<EmailVerificationToken> findByUserAndIsUsedFalseAndIsExpiredFalse(User user);

}
