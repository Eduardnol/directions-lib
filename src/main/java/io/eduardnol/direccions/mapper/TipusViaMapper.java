package io.eduardnol.direccions.mapper;

import io.eduardnol.direccions.dto.ComboDTO;
import io.eduardnol.direccions.entity.TipusViaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TipusViaMapper {
    @Mapping(target = "key", source = "idTipusVia")
    @Mapping(target = "value", source = "nom")
    ComboDTO toComboDTO(TipusViaEntity tipusViaEntity);
}
