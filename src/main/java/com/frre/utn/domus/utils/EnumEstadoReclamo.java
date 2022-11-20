package com.frre.utn.domus.utils;

public enum EnumEstadoReclamo {
    EN_ESPERA("EN_ESPERA"),
    ACEPTADO("ACEPTADO"),
    TERMINADO("TERMINADO"),
    CANCELADO("CANCELADO"),
    RECHAZADO("RECHAZADO");

    private final String estado;

    EnumEstadoReclamo(final String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return this.estado;
    }
}
