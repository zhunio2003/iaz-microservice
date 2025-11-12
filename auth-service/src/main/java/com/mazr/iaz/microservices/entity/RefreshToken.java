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
@Table(name = "refresh_tokens")
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    
    @NotBlank(message = "Token is required")
    @Column(nullable = false)
    private String token;

    @NotBlank(message = "Token Hash is required")
    @Column(nullable = false, unique = true)
    private String tokenHash;

    @NotNull(message = "Expires at is required")
    @Column(nullable = false)
    private LocalDateTime expiresAt;

    @NotNull(message = "Token is required")
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;
    
    private LocalDateTime lastUsedAt;
        
    private LocalDateTime revokedAt;
        
    private Long revokedBy;

    @Column(columnDefinition = "TEXT")
    private String revokedReason;

    @NotNull(message = "Is Active is required")
    @Column(nullable = false)
    @Builder.Default
    private Boolean isActive = true;
        
    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean isUsed = false;
      
    @Builder.Default
    private Integer usageCount = 1;
    
    @NotNull(message = "Ma usage count is required")
    @Column(nullable = false)
    private Integer maxUsageCount;

    private String deviceType;

    private String deviceName;
    
    private String deviceId;
    
    private String os;

    private String browser;

    private String browserVersion;

    private String ipAddress;

    private String locationAddress;

    private String locationCity;

    private String locationCountry;

    @Column(columnDefinition = "TEXT")
    private String userAgent;

    private Long parentTokenId;

    private Long replacedByTokenId;

    @NotNull(message = "Rotation count is required")
    @Column(nullable = false)
    @Builder.Default
    private Integer rotationCount = 1;

    @NotNull(message = "Security scope is required")
    @Column(nullable = false)
    private Integer securityScore;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean isSuspicious = false;

    private String lastActivityType;

    @Column(columnDefinition = "jsonb")
    private String metadata;

    @UpdateTimestamp    
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;


}
