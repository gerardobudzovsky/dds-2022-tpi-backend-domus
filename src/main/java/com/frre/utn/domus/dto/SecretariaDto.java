package com.frre.utn.domus.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class SecretariaDto {
	
    private String apellido;

    private String nombre;

    private String dni;

    private String cuit;

    private LocalDate fechaDeNacimiento;

    private String telefono;

    private String email;

}
