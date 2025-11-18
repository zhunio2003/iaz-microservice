package com.mazr.iaz.microservices.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazr.iaz.microservices.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);

    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);

    Optional<User> findByEmailAndDeletedAtIsNull(String email);
    Optional<User> findByUsernameAndDeletedAtIsNull(String username);

    Boolean existsByEmailAndDeletedAtIsNull(String email);
    Boolean existsByUsernameAndDeletedAtIsNull(String username);
    
}
