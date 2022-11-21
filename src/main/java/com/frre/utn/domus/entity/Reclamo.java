package com.frre.utn.domus.entity;

import javax.persistence.*;

import com.frre.utn.domus.utils.EnumEstadoReclamo;
import com.frre.utn.domus.utils.EnumPrioridad;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

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
        
    private String nombreDeContacto;

    private String telefonoDeContacto;

    private LocalDate fechaDeApertura;

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
