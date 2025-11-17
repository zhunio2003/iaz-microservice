package com.mazr.iaz.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.mazr.iaz.microservices.entity.User;

@Repository
public interface PasswordResetToken extends JpaRepository<User, Long>{
    
}
