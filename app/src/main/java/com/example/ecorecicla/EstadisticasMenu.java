package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EstadisticasMenu extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas_menu);


        ImageButton ajustarEstadisticas = findViewById(R.id.ajustar_estadisticas_btn);
        ajustarEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Opción Temporalmente Deshabilitada", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton filtroEstadisticas = findViewById(R.id.filtro_categorias_btn);
        final Intent intentFiltroEstadisticas = new Intent(this, FiltroCategoria.class);
        filtroEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentFiltroEstadisticas);
            }
        });


        ImageButton volverEstadisticas = findViewById(R.id.volver_estadisticas_btn);
        final Intent intentVolverEstadisticas = new Intent(this, PantallaPrincipal.class);
        volverEstadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolverEstadisticas);
            }
        });
    }
}
