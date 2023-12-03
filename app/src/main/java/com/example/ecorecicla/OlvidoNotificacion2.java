package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OlvidoNotificacion2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olvido_notificacion_2);

        Button aceptar = findViewById(R.id.aceptar_olvido_btn);
        final Intent intentAceptar = new Intent(this, InicioDeSesion.class);
        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentAceptar);
            }
        });
    }
}