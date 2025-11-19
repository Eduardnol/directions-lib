package io.eduardnol.direccions.mapper;

import io.eduardnol.direccions.dto.ComboCodeDTO;
import io.eduardnol.direccions.dto.ComboDTO;
import io.eduardnol.direccions.entity.PaisEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PaisMapper {

    @Mapping(target = "key", source = "idPais")
    @Mapping(target = "value", source = "nom")
    ComboDTO toDTOCombo(PaisEntity paisEntity);

    @Mapping(target = "key", source = "idPais")
    @Mapping(target = "code", source = "codi")
    @Mapping(target = "value", source = "nom")
    ComboCodeDTO toDTOComboCode(PaisEntity paisEntity);
}
