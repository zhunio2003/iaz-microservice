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
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
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
@Table(name = "role_permissions")
public class RolePermission {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "permission_id", nullable = false)
    private Permission permission;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    private Long revokedBy;

    private Long approvedBy;

    private Long assignedBy;

    private Long inheritedFromRoleId;

    @NotNull
    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime assignedAt;

    private LocalDateTime expiresAt;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @NotNull
    @Column(nullable = false)
    @Builder.Default
    private Boolean isInherited = false;

    @NotNull(message = "Priority at is required")
    @Column(nullable = false)
    private Integer priority;

    @Column(columnDefinition = "jsonb")
    private String conditions;

    @Column(columnDefinition = "jsonb")
    private String overrideConditions;

    private Boolean grantOption;

    private Boolean isDenied;

    @Column(columnDefinition = "TEXT")
    private String denyReason;

    private Long usageCount;

    private LocalDateTime lastUsedAt;

    private Boolean isRevocable;

    private LocalDateTime revokedAt;
    
    @Column(columnDefinition = "TEXT")
    private String revokedReason;

    private LocalDateTime effectiveFrom;

    private LocalDateTime effectiveUntil;

    private String autoRevokeOn;

    private Boolean notificationSent;

    private LocalDateTime notificationSentAt;

    private Boolean approvalRequired;

    private LocalDateTime approvedAt;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(columnDefinition = "jsonb")
    private String metadata;

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
