package com.example.ecorecicla.modelos;

public class Metales {

    private float cantidadMetales;
    private String fechaMetales;

    public Metales(float cantidadMetales, String fechaMetales) {
        this.cantidadMetales = cantidadMetales;
        this.fechaMetales = fechaMetales;
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
