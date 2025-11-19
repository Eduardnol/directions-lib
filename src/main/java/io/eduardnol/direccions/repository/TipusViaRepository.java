package io.eduardnol.direccions.repository;

import io.eduardnol.direccions.entity.TipusViaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TipusViaRepository extends JpaRepository<TipusViaEntity, Long> {
    Optional<TipusViaEntity> findByNomIgnoreCase(String nom);
    Optional<TipusViaEntity> findByNomIgnoreCaseOrCodiIgnoreCase(String nom, String codi);
}
