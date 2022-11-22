package com.frre.utn.domus.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Propiedad {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
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
	@ManyToMany(mappedBy = "propiedades")
	private Set<Cliente> clientes; // = new HashSet<>();


}
