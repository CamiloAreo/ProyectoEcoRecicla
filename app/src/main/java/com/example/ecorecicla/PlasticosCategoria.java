package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class PlasticosCategoria extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plasticos_categoria);

        Button plasticosGuardar = findViewById(R.id.plasticos_guardar_btn);
        Button plasticosBorrar = findViewById(R.id.plasticos_borrar_btn);
        EditText plasticosEditText = findViewById(R.id.plasticos_cantidad_txt);
        plasticosBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plasticosEditText.setText("");
            }
        });

        Button volverPlasticos = findViewById(R.id.plasticos_volver_btn);
        final Intent intentVolverPlasticos = new Intent(this, CategoriasMenu.class);
        volverPlasticos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolverPlasticos);
            }
        });
    }
}
