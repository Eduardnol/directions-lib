package io.eduardnol.direccions.repository;

import io.eduardnol.direccions.entity.CodiPostalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CodiPostalRepository extends JpaRepository<CodiPostalEntity, Long> {
    Optional<CodiPostalEntity> findByCodiPostalAndMunicipiCodi(String codiPostal, String codiMunicipi);
    Optional<CodiPostalEntity> findByCodiPostalAndMunicipiIdMunicipi(String codiPostal, Long idMunicipi);
}
