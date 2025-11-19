package io.eduardnol.direccions.mapper;

import io.eduardnol.direccions.dto.ComboDTO;
import io.eduardnol.direccions.entity.MunicipiEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface MunicipiMapper {
    @Mapping(target = "key", source = "idMunicipi")
    @Mapping(target = "value", source = "nom")
    ComboDTO toComboDTO(MunicipiEntity municipiEntity);
}
