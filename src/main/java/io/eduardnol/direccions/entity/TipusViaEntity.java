package io.eduardnol.direccions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "md_tipus_via")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TipusViaEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTipusVia;

    @Column(name = "codi", length = 10)
    private String codi;

    @Column(name = "nom", length = 64)
    private String nom;

    public TipusViaEntity(Long idTipusVia) {
        this.idTipusVia = idTipusVia;
    }
}
