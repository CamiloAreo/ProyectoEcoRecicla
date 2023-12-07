package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class PantallaPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pantalla_principal);

        Button categorias = findViewById(R.id.categorias_btn);
        final Intent intentCategorias = new Intent(this, CategoriasMenu.class);
        categorias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCategorias);
            }
        });

        Button estadisticas = findViewById(R.id.estadisticas_btn);
        final Intent intentEstadisticas = new Intent(this, EstadisticasMenu.class);
        estadisticas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentEstadisticas);
            }
        });

        Button tips = findViewById(R.id.tips_btn);
        final Intent intentTips = new Intent(this, TipsMenu.class);
        tips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentTips);
            }
        });

        ImageButton cerrar = findViewById(R.id.cerrar_btn);
        final Intent intentCerrar = new Intent(this, InicioDeSesion.class);
        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCerrar);
            }
        });
    }
}
