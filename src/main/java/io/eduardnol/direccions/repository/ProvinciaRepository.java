package io.eduardnol.direccions.repository;

import io.eduardnol.direccions.entity.ProvinciaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProvinciaRepository extends JpaRepository<ProvinciaEntity, Long> {
    List<ProvinciaEntity> findAllByComunitatAutonomaIdComunitatAutonoma(Long idComunitatAutonoma);
    Optional<ProvinciaEntity> findByCodi(String codi);
    Optional<ProvinciaEntity> findFirstByNomIs(String nom);
}
