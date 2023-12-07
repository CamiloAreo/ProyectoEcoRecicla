package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EstadisticasCategoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estadisticas_categoria);

        ImageButton ajustarEstadisticaCategoria = findViewById(R.id.ajustar_estadisticas_categoria_btn);
        ajustarEstadisticaCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Opción Temporalmente Deshabilitada", Toast.LENGTH_SHORT).show();
            }
        });

        ImageButton volverFiltroCategorias = findViewById(R.id.volver_estadisticas_categoria_btn);
        final Intent intentVolverFiltroCategorias = new Intent(this, FiltroCategoria.class);
        volverFiltroCategorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolverFiltroCategorias);
            }
        });
    }


}
