package com.mazr.iaz.microservices.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Data
@Table(name = "users")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(unique = true, nullable = false)
    private String email;

    private String firstName;

    private String lastName;

    private String avatar;

    @Column(nullable = false)
    private String passwordHash;

    private Boolean accountLocked = false;
    
    private Integer failedLoginAttempts;

    private LocalDateTime lockedUntil;

    @CreationTimestamp // SE LLENA AUTOMATICAMENTE AL CREAR
    private LocalDateTime createdAt;

    @UpdateTimestamp // SE ACTUALIZA AUTOMATICAMENTE
    private LocalDateTime updatedAt;

    private LocalDateTime lastLoginAt;

    private LocalDateTime deletedAt;

}
