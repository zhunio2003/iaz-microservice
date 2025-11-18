package com.mazr.iaz.microservices.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mazr.iaz.microservices.entity.LoginAttempt;
import com.mazr.iaz.microservices.entity.User;

public interface LoginAttemptRepository extends JpaRepository<LoginAttempt, Long>{

    // Ver los login fallidos durante un cierto tiempo 
    List<LoginAttempt> findByUserAndSuccessFalseAndAttemptedAtBetween(User user, LocalDateTime start, LocalDateTime end);
    
    Long countByUserAndSuccessFalseAndAttemptedAtBetween(User user, LocalDateTime start, LocalDateTime end);

    // Ver el ultimo login exitoso
    Optional<LoginAttempt> findFirstByUserAndSuccessTrueAndAttemptedAtAfterOrderByAttemptedAtDesc(User user, LocalDateTime date);

    // Auditoria
    List<LoginAttempt> findByUser(User user);

    // Monitorear por IP
    Long countByIpAddressAndAttemptedAtAfter(String ipAddress, LocalDateTime date);

    // Consultar si tiene actividad sospechosa
    List<LoginAttempt> findByUserAndIsSuspiciousTrue(User user);




} 
