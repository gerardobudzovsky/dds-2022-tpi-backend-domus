package com.frre.utn.domus.entity;

import javax.persistence.*;

import com.frre.utn.domus.utils.EnumEstadoReclamo;
import com.frre.utn.domus.utils.EnumPrioridad;

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

    @Enumerated(EnumType.STRING)
    private EnumEstadoReclamo estado;

    @Enumerated(EnumType.STRING)
    private EnumPrioridad prioridad;
}
