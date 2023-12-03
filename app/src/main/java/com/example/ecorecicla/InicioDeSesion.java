package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.modelos.Usuario;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class InicioDeSesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_de_sesion);

        EditText usuarioEditText = findViewById(R.id.usuario_txt);
        EditText contrasenaEditText = findViewById(R.id.contrasena_txt);

        File file = new File(getFilesDir(), "datos.txt");
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                // Dividir la línea en los datos del usuario separados por comas
                String[] userData = line.split(",");
                String nombre = userData[0];
                String correo = userData[1];
                String nickname = userData[2];
                String passwordData = userData[3];
                // Crear un objeto Usuario y añadirlo a la lista de usuarios
                Usuario nuevoUsuario = new Usuario(nombre, correo, nickname, passwordData);
                usuarios.add(nuevoUsuario);
            }
            reader.close();

            // Imprimir información de los usuarios leídos en el archivo
            for (Usuario usuario : usuarios) {
                Log.d("Usuarios",
                        "Nombre: " + usuario.getNombre() + ", Correo: " + usuario.getCorreo() +
                                ", Nickname: " + usuario.getNickname() + ", Password: " + usuario.getPassword());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView iniciarSesion = findViewById(R.id.iniciar_sesion_btn);
        final Intent intentIniciarSesion = new Intent(this, PantallaPrincipal.class);
        iniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si se han ingresado datos de usuario y contraseña
                if (!usuarioEditText.getText().toString().isEmpty() && !contrasenaEditText.getText().toString().isEmpty()) {
                    String inputUsuario = usuarioEditText.getText().toString();
                    String inputPassword = contrasenaEditText.getText().toString();

                    // Buscar el usuario coincidente en la lista de usuarios
                    for (Usuario usuario : usuarios) {
                        if (usuario.getPassword().equals(inputPassword)) {
                            if (usuario.getNickname().equals(inputUsuario) || usuario.getCorreo().equals(inputUsuario) || usuario.getNombre().equals(inputUsuario)) {
                                // Si se encuentra una coincidencia, iniciar la actividad principal y salir del bucle
                                startActivity(intentIniciarSesion);
                                return;
                            }
                        }
                    }
                    // Si no se encontró una coincidencia, mostrar un mensaje de error utilizando Toast
                    Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });

        TextView registro = findViewById(R.id.registro_txv);
        final Intent intentRegistro = new Intent(this, Registro.class);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentRegistro);
            }
        });

        TextView olvidaste = findViewById(R.id.olvidaste_txv);
        final Intent intentOlvidaste = new Intent(this, OlvidoNotificacion1.class);
        olvidaste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentOlvidaste);
            }
        });
    }
}
