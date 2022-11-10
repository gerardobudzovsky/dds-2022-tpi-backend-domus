package com.frre.utn.domus.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import com.frre.utn.domus.dto.SecretariaDto;
import com.frre.utn.domus.entity.Secretaria;

@Mapper(componentModel = "spring")
public interface SecretariaMapper {

	Secretaria fromDto(SecretariaDto secretariaDto);
	
	Secretaria merger (SecretariaDto secretariaDto, @MappingTarget Secretaria secretaria);
}
