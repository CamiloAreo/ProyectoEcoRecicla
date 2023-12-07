package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FiltroCategoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filtro_categoria);

        Button papelFiltro = findViewById(R.id.papel_filtro_btn);
        final Intent intentPapelFiltro = new Intent(this, EstadisticasCategoria.class);
        papelFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPapelFiltro);
            }
        });

        Button plasticosFiltro = findViewById(R.id.plasticos_filtro_btn);
        final Intent intentPlasticosFiltro = new Intent(this, EstadisticasCategoria.class);
        plasticosFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPlasticosFiltro);
            }
        });

        Button vidrioFiltro = findViewById(R.id.vidrio_filtro_btn);
        final Intent intentVidrioFiltro = new Intent(this, EstadisticasCategoria.class);
        vidrioFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVidrioFiltro);
            }
        });

        Button metalesFiltro = findViewById(R.id.metales_filtro_btn);
        final Intent intentMetalesFiltro = new Intent(this, EstadisticasCategoria.class);
        metalesFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentMetalesFiltro);
            }
        });

        Button cancelarFiltro = findViewById(R.id.cancelar_filtro_btn);
        final Intent intentCancelarFiltro = new Intent(this, EstadisticasMenu.class);
        cancelarFiltro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCancelarFiltro);
            }
        });
    }
}