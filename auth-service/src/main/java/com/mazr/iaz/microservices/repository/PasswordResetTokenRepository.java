    package com.mazr.iaz.microservices.repository;

    import java.util.List;
    import java.util.Optional;

    import org.springframework.data.jpa.repository.JpaRepository;
    import org.springframework.stereotype.Repository;

    import com.mazr.iaz.microservices.entity.PasswordResetToken;
    import com.mazr.iaz.microservices.entity.User;

    @Repository
    public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long>{

        Optional<PasswordResetToken> findByTokenHash(String tokenHash);

        // Verificar si el password es correcto
        Optional<PasswordResetToken> findByTokenHashAndIsUsedFalseAndIsExpiredFalseAndInvalidatedAtIsNull(String tokenHash);

        // Contar tokens validos
        Long countByUserAndIsUsedFalseAndIsExpiredFalseAndInvalidatedAtIsNull(User user);

        // Auditoria
        List<PasswordResetToken> findByUser(User user);
        
        // Invalidar todos los tokens cuando se cree uno nuevo
        List<PasswordResetToken> findByUserAndIsUsedFalseAndIsExpiredFalseAndInvalidatedAtIsNull(User user);

    }
