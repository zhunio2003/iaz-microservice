package com.mazr.iaz.microservices.entity;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
@Table(name = "password_reset_tokens")
public class PasswordResetToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Long invalidatedBy;

    @NotBlank(message = "TOKEN is required")
    @Column(nullable = false)
    private String token;

    @NotBlank(message = "TOKEN HASH is required")
    @Column(unique = true, nullable = false)
    private String tokenHash;

    @NotNull(message = "Expires at is required")
    @Column(nullable = false)
    private LocalDateTime  expiresAt;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @Email
    private String email;

    private LocalDateTime usedAt;

    @NotNull(message = "IS USED is required")
    @Column(nullable = false)
    @Builder.Default
    private Boolean isUsed = false;

    @NotNull(message = "IS EXPIRED is required")
    @Column(nullable = false)
    @Builder.Default
    private Boolean isExpired = false;

    @Builder.Default
    private Integer attemptsCount = 0;

    @NotBlank(message = "IP ADDRESS is required")
    @Column(nullable = false)
    private String ipAddress;

    private String resetIpAddress;

    @Column(columnDefinition = "TEXT")
    private String userAgent;

    private String requestReason;

    private Boolean success;

    private String oldPasswordHash;

    private String newPasswordHash;

    private LocalDateTime invalidatedAt;
    
    @Column(columnDefinition = "TEXT")
    private String invalidatedReason;

    private String deviceInfo;

    private String locationCountry;

    private String locationCity;

    private Boolean securityQuestionsVerified;

    private Boolean twoFactorVerified;

    private Boolean notificationSent;

    private LocalDateTime notificationSentAt;

    @Column(columnDefinition = "jsonb")
    private String metadata;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
