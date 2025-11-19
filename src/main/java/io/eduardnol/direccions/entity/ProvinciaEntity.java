package io.eduardnol.direccions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "md_provincia")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProvinciaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProvincia;

    @Column(name = "codi", length = 10)
    private String codi;

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_comunitat_autonoma")
    private ComunitatAutonomaEntity comunitatAutonoma;

    public ProvinciaEntity(Long idProvincia) {
        this.idProvincia = idProvincia;
    }
}
