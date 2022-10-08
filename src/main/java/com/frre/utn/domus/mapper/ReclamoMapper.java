package com.frre.utn.domus.mapper;

import com.frre.utn.domus.dto.ReclamoDto;
import com.frre.utn.domus.entity.Reclamo;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ReclamoMapper {

	Reclamo fromDto(ReclamoDto reclamoDto);
	
	Reclamo merger (ReclamoDto reclamoDto, @MappingTarget Reclamo reclamo);
}
