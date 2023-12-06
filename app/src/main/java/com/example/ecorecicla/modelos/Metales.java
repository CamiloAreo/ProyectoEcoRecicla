package com.example.ecorecicla.modelos;

public class Metales {

    private String fechaMetales;
    private float cantidadMetales;
    public Metales(String fechaMetales, float cantidadMetales) {
        this.fechaMetales = fechaMetales;
        this.cantidadMetales = cantidadMetales;
    }

    public float getCantidadMetales() {
        return cantidadMetales;
    }

    public void setCantidadMetales(float cantidadMetales) {
        this.cantidadMetales = cantidadMetales;
    }

    public String getFechaMetales() {
        return fechaMetales;
    }

    public void setFechaMetales(String fechaMetales) {
        this.fechaMetales = fechaMetales;
    }
}
