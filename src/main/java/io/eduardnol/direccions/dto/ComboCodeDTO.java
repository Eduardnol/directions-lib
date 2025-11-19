package io.eduardnol.direccions.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComboCodeDTO {
    private Long key;
    private String code;
    private String value;
}
