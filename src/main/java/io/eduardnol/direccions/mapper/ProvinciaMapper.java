package io.eduardnol.direccions.mapper;

import io.eduardnol.direccions.dto.ComboDTO;
import io.eduardnol.direccions.entity.ProvinciaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProvinciaMapper {
    @Mapping(target = "key", source = "idProvincia")
    @Mapping(target = "value", source = "nom")
    ComboDTO toComboDTO(ProvinciaEntity provincia);
}
