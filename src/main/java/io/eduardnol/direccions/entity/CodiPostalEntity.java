package io.eduardnol.direccions.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "md_codi_postal")
@Data
@NoArgsConstructor
public class CodiPostalEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCodiPostal;

    @Column(name = "codi_postal")
    private String codiPostal;

    @ManyToOne
    @JoinColumn(name = "id_municipi")
    private MunicipiEntity municipi;

    public CodiPostalEntity(Long idCodiPostal, String codiPostal) {
        this.idCodiPostal = idCodiPostal;
        this.codiPostal = codiPostal;
    }
}
