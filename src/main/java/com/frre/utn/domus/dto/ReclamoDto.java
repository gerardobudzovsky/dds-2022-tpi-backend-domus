package com.frre.utn.domus.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.frre.utn.domus.entity.Propiedad;

import lombok.Data;

@Data
public class ReclamoDto {
	
    private String descripcion;
    
    @ManyToOne
    @JoinColumn
    private Propiedad propiedad;
    
//  @ManyToOne
//  @JoinColumn
//  private Cliente clienteQueReclama;
    
//  @ManyToOne
//  @JoinColumn
//  private Secretaria secretariaCreadora;

}
