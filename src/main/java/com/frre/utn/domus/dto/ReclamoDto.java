package com.frre.utn.domus.dto;

import com.frre.utn.domus.entity.Cliente;
import com.frre.utn.domus.entity.Propiedad;
import com.frre.utn.domus.entity.Secretaria;

import com.frre.utn.domus.utils.EnumEstadoReclamo;
import com.frre.utn.domus.utils.EnumPrioridad;
import lombok.Data;

import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class ReclamoDto {

	 private String descripcion;
     
	    private String nombreDeContacto;

	    private String telefonoDeContacto;

	    private LocalDate fechaDeApertura;

	    private Propiedad propiedad;
	    
		private Cliente clienteQueReclama;
	    
		private Secretaria secretariaCreadora;

	    @Enumerated(EnumType.STRING)
	    private EnumEstadoReclamo estado;

	    @Enumerated(EnumType.STRING)
	    private EnumPrioridad prioridad;

}
