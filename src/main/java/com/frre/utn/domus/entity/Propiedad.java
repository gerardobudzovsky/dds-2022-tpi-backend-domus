package com.frre.utn.domus.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Propiedad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo; // TODO cambiar esto por un Enum

    private String pais;

    private String provincia;

    private String ciudad;

    private String calle;

    private Integer numero;

    private String barrio;

    private Integer espacios;

    private LocalDate fechaConstruccion;

    private String propietario; // TODO cambiar esto por la clase Propietario

    private String descripcionBreve;

    private String descripcionDetallada;

    private String estado; // TODO cambiar esto por un Enum

    // private ? archivosAdjuntos
}
