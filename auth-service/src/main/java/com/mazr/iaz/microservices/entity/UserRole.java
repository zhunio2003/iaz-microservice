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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Table(name = "users_roles")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @NotNull(message = "Assigned by is required")
    @Column(nullable = false)
    private Long assignedBy;
    
    private Long revokedBy;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDateTime assignedAt;

    private LocalDateTime revokedAt;

    private LocalDateTime expiresAt;

    @NotNull(message = "Is Active by is required")
    @Column(nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @NotNull(message = "Is Primary by is required")
    @Column(nullable = false)
    @Builder.Default
    private Boolean isPrimary = false;

    @Size(min = 10, max = 100, message = "Name must be a minimum of 10 and maximum of 100 characters")
    @Column(columnDefinition = "TEXT")
    private String reason;

    @Column(columnDefinition = "jsonb")
    private String metadata;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private LocalDateTime deletedAt;

}
