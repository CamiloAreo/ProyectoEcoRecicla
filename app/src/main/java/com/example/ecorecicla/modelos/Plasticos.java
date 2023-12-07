package com.example.ecorecicla.modelos;

public class Plasticos {
    private String fechaPlasticos;
    private float cantidadPlasticos;

    public Plasticos(String fechaPlasticos, float cantidadPlasticos) {
        this.fechaPlasticos = fechaPlasticos;
        this.cantidadPlasticos = cantidadPlasticos;
    }

    public String getFechaPlasticos() {
        return fechaPlasticos;
    }

    public void setFechaPlasticos(String fechaPlasticos) {
        this.fechaPlasticos = fechaPlasticos;
    }

    public float getCantidadPlasticos() {
        return cantidadPlasticos;
    }

    public void setCantidadPlasticos(float cantidadPlasticos) {
        this.cantidadPlasticos = cantidadPlasticos;
    }
}
