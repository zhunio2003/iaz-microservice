package com.mazr.iaz.microservices.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazr.iaz.microservices.entity.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
   
    Boolean existsByName(String name);

    Optional<Permission> findByName(String name);

    List<Permission> findByIsActiveTrueAndIsDeprecatedFalseAndDeletedAtIsNull();

    List<Permission> findByResourceAndAction(String resource, String action);

    List<Permission> findByIsDangerousTrue();
    
    List<Permission> findByCategory(String category);

    List<Permission> findByRequires2FaTrue();

    List<Permission> findByGroupName(String groupName);

    List<Permission> findByIsDeprecatedTrue();
    
}
