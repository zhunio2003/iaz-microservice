package com.mazr.iaz.microservices.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
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
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "permissions")
public class Permission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(nullable = false, unique = true)
    private String name;

    @NotBlank(message = "Display name is required")
    @Column(nullable = false)
    private String displayName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @NotBlank(message = "Resource is required")
    @Column(nullable = false)
    private String resource;

    @NotBlank(message = "Action is required")
    @Column(nullable = false)
    private String action;

    private String resourcePattern;

    private String scope;

    private String category;

    @NotNull(message = "Priority is required")
    @Column(nullable = false)
    private Integer priority;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean isSystem = false;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean isDangerous = false;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean requires2fa = false;

    private String riskLevel;

    @Builder.Default   
    private String effect = "ALLOW";

    @Column(columnDefinition = "jsonb")
    private String conditions;

    private Integer rateLimit;

    @Builder.Default
    private Integer costCredit = 0;

    @Column(columnDefinition = "jsonb")
    private String dependencies;

    @Column(columnDefinition = "jsonb")
    private String conflictsWith;

    private Long parentPermissionId;

    private String groupName;

    @Column(columnDefinition = "jsonb")
    private String tags;

    @Column(columnDefinition = "jsonb")
    private String metadata;

    private LocalDateTime lastUsedAt;

    @NotNull
    @Column(nullable = false)
    private Long createdBy;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean isDeprecated = false;

    @Column(columnDefinition = "TEXT")
    private String deprecatedReason;

    private Long replacementPermissionId;

    private LocalDateTime effectiveFrom;

    private LocalDateTime effectiveUntil;

    private String documentationUrl;

    @Column(columnDefinition = "TEXT")
    private String exampleUsage;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

    @PrePersist
    public void prePersist() {
        if (effectiveFrom == null) {
            effectiveFrom = LocalDateTime.now();
        }
    }

}
