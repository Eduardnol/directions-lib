package io.eduardnol.direccions.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Entity
@Table(name = "md_pais")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaisEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPais;

    @Column(name = "codi", length = 10)
    private String codi;

    @Column(name = "nom", length = 128)
    private String nom;
}

