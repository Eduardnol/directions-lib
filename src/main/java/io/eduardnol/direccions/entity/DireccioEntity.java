package io.eduardnol.direccions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "md_direccio")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DireccioEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDireccio;

    @ManyToOne
    @JoinColumn(name = "id_pais")
    private PaisEntity pais;

    @ManyToOne
    @JoinColumn(name = "id_comunitat_autonoma")
    private ComunitatAutonomaEntity comunitatAutonoma;

    @ManyToOne
    @JoinColumn(name = "id_provincia")
    private ProvinciaEntity provincia;

    @ManyToOne
    @JoinColumn(name = "id_municipi")
    private MunicipiEntity municipi;

    @ManyToOne
    @JoinColumn(name = "id_codi_postal")
    private CodiPostalEntity codiPostal;

    @ManyToOne
    @JoinColumn(name = "id_tipus_via")
    private TipusViaEntity tipusVia;

    @Column(name = "nom_via", length = 128)
    private String nomVia;

    @Column(name = "numero", length = 128)
    private String numero;

    @Column(name = "pis", length = 128)
    private String pis;

    @Column(name = "municipi_no_catala")
    private String municipiNoCatala;

    @Column(name = "codi_postal_no_catala")
    private String codiPostalNoCatala;
}
