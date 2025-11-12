package com.mazr.iaz.microservices.entity;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Column(unique = true, nullable = false)
    @Size(min = 5, max = 100, message = "Name must be a minimum of 5 and maximum of 100 characters")
    private String name;

    @NotBlank(message = "Display name is required")
    @Column(nullable = false)
    @Size(min = 5, max = 100, message = "Display name must be a minimum of 5 and maximum of 100 characters")
    private String displayName;

    @Size(min = 10, max = 500, message = "Description must be a minimum of 10 and maximum of 500 characters")
    @Column(columnDefinition = "TEXT")
    private String description;

    @NotNull(message = "Level is required")
    @Column(nullable = false)
    private Integer level;

    @Pattern(regexp = "^#[0-9A-Fa-f]{6}$", message = "Color must be hex format (#RRGGBB")
    private String color;

    private String icon;

    private Integer maxUsers;

    @Column(nullable = false)
    @Builder.Default
    private Boolean isActive = true;

    @Column(nullable = false)
    @Builder.Default
    private Boolean isSystem = false;

    @Column(nullable = false)
    @Builder.Default
    private Boolean isAssignable = true;

    @Column(columnDefinition = "jsonb")
    private String metadata;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @NotNull(message = "Created by is required")
    @Column(nullable = false)
    private Long createdBy;

    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "role")
    @Builder.Default
    private Set<UserRole> userRoles = new HashSet<>();

}
