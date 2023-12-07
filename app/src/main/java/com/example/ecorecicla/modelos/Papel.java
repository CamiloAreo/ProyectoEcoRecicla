package com.example.ecorecicla.modelos;

public class Papel {
    private String fechaPapel;
    private float cantidadPapel;

    public Papel(String fechaPapel, float cantidadPapel) {
        this.fechaPapel = fechaPapel;
        this.cantidadPapel = cantidadPapel;
    }

    public String getFechaPapel() {
        return fechaPapel;
    }

    public void setFechaPapel(String fechaPapel) {
        this.fechaPapel = fechaPapel;
    }

    public float getCantidadPapel() {
        return cantidadPapel;
    }

    public void setCantidadPapel(float cantidadPapel) {
        this.cantidadPapel = cantidadPapel;
    }
}
