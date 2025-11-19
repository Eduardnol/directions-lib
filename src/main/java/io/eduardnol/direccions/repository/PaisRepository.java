package io.eduardnol.direccions.repository;

import io.eduardnol.direccions.entity.PaisEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PaisRepository extends JpaRepository<PaisEntity, Long> {
    Optional<PaisEntity> findByCodi(String codi);
    Optional<PaisEntity> findFirstByNom(String nom);
}
