package com.frre.utn.domus.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.frre.utn.domus.entity.Cliente;

@Data
public class PropiedadDto {

    private String codigoProp;
    
    private Boolean alquiler;
    
    private Boolean venta;
    
    private Boolean activa;
    
    private Boolean destacada;
    
    private String direccion;
    
    private String tipoDePropiedad;
    
    private Integer habitaciones;
    
    private Integer banhos;
    
    private String garage;
    
    private String fotos;
    
    @JsonIgnore
	private Set<Cliente> clientes; // = new HashSet<>();
	
}
