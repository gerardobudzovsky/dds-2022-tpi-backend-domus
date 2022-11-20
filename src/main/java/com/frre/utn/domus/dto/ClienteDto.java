package com.frre.utn.domus.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ClienteDto {

	private String tipoDeCliente;

	private String apellido;

	private String nombre;

	private String dni;

	private String cuit;

	private LocalDate fechaDeNacimiento;

	private String telefono;

	private String email;

}
