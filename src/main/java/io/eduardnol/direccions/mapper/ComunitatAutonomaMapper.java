package io.eduardnol.direccions.mapper;

import io.eduardnol.direccions.dto.ComboCodeDTO;
import io.eduardnol.direccions.dto.ComboDTO;
import io.eduardnol.direccions.entity.ComunitatAutonomaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ComunitatAutonomaMapper {

    @Mapping(target = "key", source = "idComunitatAutonoma")
    @Mapping(target = "value", source = "nom")
    ComboDTO toComboDTO(ComunitatAutonomaEntity comunitatAutonomaEntity);

    @Mapping(target = "key", source = "idComunitatAutonoma")
    @Mapping(target = "code", source = "codi")
    @Mapping(target = "value", source = "nom")
    ComboCodeDTO toComboCodeDTO(ComunitatAutonomaEntity comunitatAutonomaEntity);
}
