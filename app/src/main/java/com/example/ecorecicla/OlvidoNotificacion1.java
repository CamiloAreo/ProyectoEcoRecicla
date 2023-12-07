package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.modelos.Usuario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OlvidoNotificacion1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.olvido_notificacion_1);

        EditText correoOlvido = findViewById(R.id.correo_olvido_txt);

        Button enviar = findViewById(R.id.enviar_olvido_btn);
        final Intent intentEnviar = new Intent(this, OlvidoNotificacion2.class);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!correoOlvido.getText().toString().isEmpty()) {
                    Usuario nuevoCorreo = new Usuario(correoOlvido.getText().toString());
                    guardarCorreo(nuevoCorreo);
                    startActivity(intentEnviar);
                } else {
                    Toast.makeText(getApplicationContext(), "El Campo No puede estar vacíos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button cancelar = findViewById(R.id.cancelar_olvido_btn);
        final Intent intentCancelar = new Intent(this, InicioDeSesion.class);
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentCancelar);
            }
        });
    }

    private void guardarCorreo(Usuario correoOlvidado) {
        File file = new File(getFilesDir(), "correosOlvidos.txt");

        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String nuevoCorreoOlvidado = correoOlvidado.getCorreo();
            bufferedWriter.write(nuevoCorreoOlvidado);
            bufferedWriter.newLine();
            bufferedWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
