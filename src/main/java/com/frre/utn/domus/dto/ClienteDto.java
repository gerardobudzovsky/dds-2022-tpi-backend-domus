package com.frre.utn.domus.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frre.utn.domus.entity.Propiedad;

@Data
public class ClienteDto {

	private String tipoDeCliente;

	private String apellido;

	private String nombre;

	private String dni;

	private String cuit;

	private LocalDate fechaDeNacimiento;

	private String nroCelular;

	private String email;
	
    private String nombreEmpresa;
    
    private String nroDeTelefono;
	
    @JsonIgnore
	private Set<Propiedad> propiedades; // = new HashSet<>();

}
