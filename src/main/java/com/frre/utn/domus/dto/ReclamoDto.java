package com.frre.utn.domus.dto;

import java.time.LocalDateTime;
import com.frre.utn.domus.entity.Cliente;
import com.frre.utn.domus.entity.Propiedad;
import com.frre.utn.domus.entity.Secretaria;

import lombok.Data;

@Data
public class ReclamoDto {

	private String descripcion;
	
//    private LocalDateTime fechaDeCreacion;
//
//    private LocalDateTime fechaDeModificacion;

	private Propiedad propiedad;

	private Cliente clienteQueReclama;

	private Secretaria secretariaCreadora;

}
