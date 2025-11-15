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
@Table(name = "login_attempts")
public class LoginAttempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotBlank(message = "Email is required")
    @Column(nullable = false)

    @Email
    private String emailAttempted;

    private String usernameAttempted;

    @NotNull(message = "Success is required")
    @Column(nullable = false)
    private Boolean success;

    @NotBlank(message = "IP Address is required")
    @Column(nullable = false)
    private String ipAddress;

    @Column(columnDefinition = "TEXT")
    private String userAgent;

    private String deviceType;

    private String deviceName;

    private String os;

    private String browser;

    private String browserVersion;

    private String locationCity;

    private String locationCountry;

    @Column(columnDefinition = "TEXT")
    private String failureReason;

    @NotNull()
    @Column(nullable = false)
    @Builder.Default
    private Boolean accountLocked = false;

    private Integer attemptsBeforeLock;

    private Integer riskScore;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean isSuspicious = false;

    private LocalDateTime blockedAt;

    private LocalDateTime unblockedAt;

    private Long unblockedBy;

    private String sessionId;

    private String requestId;

    private String loginMethod;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean twoFactorAttempts = false;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean twoFactorSuccess = false;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean captchaAttempts = false;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean captchaSuccess = false;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean geofenceCheck = false;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean velocityCheck = false;

    private String deviceFingerprint;

    private String referrerUrl;
   
    @Column(columnDefinition = "jsonb")
    private String metadata;

    @NotNull
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime attemptedAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
    
}
