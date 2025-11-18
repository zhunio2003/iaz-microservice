package com.mazr.iaz.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mazr.iaz.microservices.entity.Role;

@Repository
public interface RoleUserRepository extends JpaRepository<Role, Long>{
    

}
