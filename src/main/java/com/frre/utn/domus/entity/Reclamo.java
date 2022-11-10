package com.frre.utn.domus.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reclamo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String descripcion;
        
//    @CreatedDate
//    @Column(nullable = false, updatable = false)
//    private LocalDateTime fechaDeCreacion;
//
//    @LastModifiedDate
//    private LocalDateTime fechaDeModificacion;
    
    @ManyToOne
    @JoinColumn
    private Propiedad propiedad;
    
	@ManyToOne
	@JoinColumn
	private Cliente clienteQueReclama;
    
	@ManyToOne
	@JoinColumn
	private Secretaria secretariaCreadora;
	
}
