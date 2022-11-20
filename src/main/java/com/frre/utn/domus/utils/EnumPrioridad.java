package com.frre.utn.domus.utils;

public enum EnumPrioridad {
    BAJA("BAJA"),
    MEDIA("MEDIA"),
    ALTA("ALTA");

    private final String prioridad;

    EnumPrioridad(final String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return this.prioridad;
    }
}
