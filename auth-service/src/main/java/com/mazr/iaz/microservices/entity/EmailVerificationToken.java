package com.mazr.iaz.microservices.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "email_verificacion_tokens")
public class EmailVerificationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank(message = "Token is required")
    @Column(nullable = false, unique = true)
    private String token;

    @NotNull
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @NotNull
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    private LocalDateTime usedAt;

    private String ipAddress;

    @NotNull(message = "Is Used at is required")
    @Column(nullable = false)
    private Boolean isUsed;

    @NotNull(message = "Is Expired is required")
    @Column(nullable = false)
    private Boolean isExpired;

}
