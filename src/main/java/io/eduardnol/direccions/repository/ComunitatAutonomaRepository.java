package io.eduardnol.direccions.repository;

import io.eduardnol.direccions.entity.ComunitatAutonomaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ComunitatAutonomaRepository extends JpaRepository<ComunitatAutonomaEntity, Long> {
    Optional<ComunitatAutonomaEntity> findByCodi(String codi);
    List<ComunitatAutonomaEntity> findAllByPaisIdPais(Long idPais);
    Optional<ComunitatAutonomaEntity> findFirstByNom(String nom);
    Optional<ComunitatAutonomaEntity> findFirstByNomIs(String nom);
}
