package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CategoriasMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.categorias_menu);

        Button papelCategoria = findViewById(R.id.papel_btn);
        final Intent intentPapelCategoria = new Intent(this, PapelCategoria.class);
        papelCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPapelCategoria);
            }
        });

        Button plasticosCategoria = findViewById(R.id.plasticos_btn);
        final Intent intentPlasticosCategoria = new Intent(this, PlasticosCategoria.class);
        plasticosCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentPlasticosCategoria);
            }
        });

        Button vidrioCategoria = findViewById(R.id.vidrio_btn);
        final Intent intentVidrioCategoria = new Intent(this, VidrioCategoria.class);
        vidrioCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVidrioCategoria);
            }
        });

        Button metalesCategoria = findViewById(R.id.metales_btn);
        final Intent intentMetalesCategoria = new Intent(this, MetalesCategoria.class);
        metalesCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentMetalesCategoria);
            }
        });

        Button agregarCategoria = findViewById(R.id.agregar_btn);
        agregarCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Opción Temporalmente Deshabilitada", Toast.LENGTH_SHORT).show();
            }
        });

        Button volverCategoria = findViewById(R.id.categorias_volver_btn);
        final Intent intentVolverCategoria = new Intent(this, PantallaPrincipal.class);
        volverCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolverCategoria);
            }
        });
    }
}
