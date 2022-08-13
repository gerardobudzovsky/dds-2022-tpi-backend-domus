package com.frre.utn.domus.mapper;

import com.frre.utn.domus.dto.PropiedadDto;
import com.frre.utn.domus.entity.Propiedad;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface PropiedadMapper {

    Propiedad fromDto(PropiedadDto dto);

    Propiedad merger(PropiedadDto dto, @MappingTarget Propiedad propiedad);
}
