package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.modelos.Usuario;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Registro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);

        final EditText nombre = findViewById(R.id.nombre_txt);
        final EditText correo = findViewById(R.id.email_txt);
        final EditText nickname = findViewById(R.id.usuario_txt);
        final EditText pass1 = findViewById(R.id.contrasena_txt);
        final EditText pass2 = findViewById(R.id.confirmaContrasena_txt);

        Button registrateBtn = findViewById(R.id.registrate_btn);
        final Intent intentRegistrateBtn = new Intent(this, RegistroExitoso.class);
        registrateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!nombre.getText().toString().isEmpty() && !correo.getText().toString().isEmpty() && !nickname.getText().toString().isEmpty()
                        && !pass1.getText().toString().isEmpty() && !pass2.getText().toString().isEmpty()) {
                    if (pass1.getText().toString().equals(pass2.getText().toString())) {
                        if (datosExisten(correo.getText().toString(), nickname.getText().toString())) {
                            // Los datos ya existen
                            Toast.makeText(getApplicationContext(), "El correo, usuario o nickname ya existen", Toast.LENGTH_SHORT).show();
                        } else {
                            Usuario usuario = new Usuario(nombre.getText().toString(), correo.getText().toString(), nickname.getText().toString(),
                                    pass1.getText().toString());
                            guardarRegistro(usuario);
                            startActivity(intentRegistrateBtn);
                        }

                    } else {
                        // Las contraseñas no coinciden
                        Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden",
                                Toast.LENGTH_SHORT).show();
                    }

                } else {
                    // Los campos estan vacios
                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                            Toast.LENGTH_SHORT).show();
                }


            }
        });

        ImageButton volver = findViewById(R.id.registro_volver_btn);
        final Intent intentVolver = new Intent(this, InicioDeSesion.class);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolver);
            }
        });
    }

    private void guardarRegistro(Usuario nuevoUsuario) {
        File file = new File(getFilesDir(), "datos.txt");

        try {
            FileWriter writer = new FileWriter(file, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            String nuevoRegistro = nuevoUsuario.getNombre() + "," + nuevoUsuario.getCorreo() + "," +
                    nuevoUsuario.getNickname() + "," + nuevoUsuario.getPassword() + "\n";
            bufferedWriter.write(nuevoRegistro);
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean datosExisten(String correo, String nickname) {
        File file = new File(getFilesDir(), "datos.txt");
        try {
            FileReader reader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(reader);
            String line;
            List<String> existingEmails = new ArrayList<>();
            List<String> existingNicknames = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                String[] data = line.split(",");
                existingEmails.add(data[1]);
                existingNicknames.add(data[2]);
            }

            bufferedReader.close();

            return existingEmails.contains(correo) || existingNicknames.contains(nickname);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }
}
