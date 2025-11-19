package io.eduardnol.direccions.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CheckCodiPostalDTO {
    private Long idMunicipi;
    private String codiPostal;
}
