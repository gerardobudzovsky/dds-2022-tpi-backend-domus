package com.frre.utn.domus.mapper;

import com.frre.utn.domus.dto.ClienteDto;
import com.frre.utn.domus.entity.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

	Cliente fromDto(ClienteDto clienteDto);
	
	Cliente merger (ClienteDto clienteDto, @MappingTarget Cliente cliente);
}
