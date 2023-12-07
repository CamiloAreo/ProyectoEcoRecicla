package com.example.ecorecicla.modelos;

public class Vidrio {
    private String fechaVidrio;
    private float cantidadVidrio;

    public Vidrio(String fechaVidrio, float cantidadVidrio) {
        this.fechaVidrio = fechaVidrio;
        this.cantidadVidrio = cantidadVidrio;
    }

    public String getFechaVidrio() {
        return fechaVidrio;
    }

    public void setFechaVidrio(String fechaVidrio) {
        this.fechaVidrio = fechaVidrio;
    }

    public float getCantidadVidrio() {
        return cantidadVidrio;
    }

    public void setCantidadVidrio(float cantidadVidrio) {
        this.cantidadVidrio = cantidadVidrio;
    }
}
