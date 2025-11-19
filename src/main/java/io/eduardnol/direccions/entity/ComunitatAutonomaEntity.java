package io.eduardnol.direccions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "md_comunitat_autonoma")
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ComunitatAutonomaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idComunitatAutonoma;

    @Column(name = "codi", length = 10)
    private String codi;

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private PaisEntity pais;

    public ComunitatAutonomaEntity(Long idComunitatAutonoma) {
        this.idComunitatAutonoma = idComunitatAutonoma;
    }
}
