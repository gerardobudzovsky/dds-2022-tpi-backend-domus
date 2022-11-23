package com.frre.utn.domus.utils;

public enum EnumPrioridad {
    baja("baja"),
    media("media"),
    alta("alta");

    private final String prioridad;

    EnumPrioridad(final String prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public String toString() {
        return this.prioridad;
    }
}
