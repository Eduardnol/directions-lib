package io.eduardnol.direccions.repository;

import io.eduardnol.direccions.entity.MunicipiEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MunicipiRepository extends JpaRepository<MunicipiEntity, Long> {
    List<MunicipiEntity> findAllByProvinciaIdProvinciaOrderByNom(Long idProvincia);
    Optional<MunicipiEntity> findByCodi(String codi);
    Optional<MunicipiEntity> findByNomIgnoreCase(String nom);
    Optional<MunicipiEntity> findFirstByNom(String nom);
}
