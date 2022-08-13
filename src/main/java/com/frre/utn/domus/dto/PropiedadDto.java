package com.frre.utn.domus.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PropiedadDto {

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
