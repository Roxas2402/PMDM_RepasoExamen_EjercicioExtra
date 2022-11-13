package com.example.pmdm_repasoexamen_ejercicioextra.models;

import java.io.Serializable;

public class PartidoModel implements Serializable {
    private String partido;
    private String resultado;
    private String descripcion;

    public PartidoModel(String partido, String resultado, String descripcion) {
        this.partido = partido;
        this.resultado = resultado;
        this.descripcion = descripcion;
    }

    public String getPartido() {
        return partido;
    }

    public void setPartido(String partido) {
        this.partido = partido;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Partido{" +
                "partido='" + partido + '\'' +
                ", resultado='" + resultado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
