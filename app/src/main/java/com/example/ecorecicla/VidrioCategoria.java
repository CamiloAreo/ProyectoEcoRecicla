package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.ecorecicla.R;

public class VidrioCategoria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vidrio_categoria);

        Button vidrioGuardar = findViewById(R.id.vidrio_guardar_btn);
        Button vidrioBorrar = findViewById(R.id.vidrio_borrar_btn);
        EditText vidrioEditText = findViewById(R.id.vidrio_cantidad_txt);
        vidrioBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidrioEditText.setText("");
            }
        });

        Button volverVidrio = findViewById(R.id.vidrio_volver_btn);
        final Intent intentVolverVidrio = new Intent(this, CategoriasMenu.class);
        volverVidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolverVidrio);
            }
        });
    }
}