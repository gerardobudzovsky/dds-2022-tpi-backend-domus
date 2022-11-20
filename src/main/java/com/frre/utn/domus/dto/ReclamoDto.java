package com.frre.utn.domus.dto;

import com.frre.utn.domus.entity.Cliente;
import com.frre.utn.domus.entity.Propiedad;
import com.frre.utn.domus.entity.Secretaria;

import com.frre.utn.domus.utils.EnumEstadoReclamo;
import com.frre.utn.domus.utils.EnumPrioridad;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReclamoDto {

	private String descripcion;
	
//    private LocalDateTime fechaDeCreacion;
//
//    private LocalDateTime fechaDeModificacion;

	private Propiedad propiedad;

	private Cliente clienteQueReclama;

	private Secretaria secretariaCreadora;

	private String nombreDeContacto;

	private String telefonoDeContacto;

	private LocalDate fecha;

	// este lo manda en null
	private EnumEstadoReclamo estado;

	private EnumPrioridad prioridad;

}
