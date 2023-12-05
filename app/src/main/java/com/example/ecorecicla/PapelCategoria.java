package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PapelCategoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.papel_categoria);

        Button papelGuardar = findViewById(R.id.papel_guardar_btn);
        Button papelBorrar = findViewById(R.id.papel_borrar_btn);
        EditText papelEditText = findViewById(R.id.papel_cantidad_txt);
        papelBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                papelEditText.setText("");
            }
        });

        Button volverPapel = findViewById(R.id.papel_volver_btn);
        final Intent intentVolverPapel = new Intent(this, CategoriasMenu.class);
        volverPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolverPapel);
            }
        });
    }
}