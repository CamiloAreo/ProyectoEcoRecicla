package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ecorecicla.modelos.Metales;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MetalesCategoria extends AppCompatActivity {

    long ahora = System.currentTimeMillis();
    Date date = new Date(ahora);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
    String fecha = df.format(date);

    TableLayout metalesTableLayout = findViewById(R.id.Metales_TableLayout);
    Button metalesGuardar = findViewById(R.id.metales_guardar_btn);
    Button metalesBorrar = findViewById(R.id.metales_borrar_btn);
    EditText metalesEditText = findViewById(R.id.metales_cantidad_txt);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metales_categoria);

        File fileMetales = new File(getFilesDir(), "metalesGuardados.txt");
        //List<Metales> listaMetales = leerMetales(fileMetales);
        //addMetales(listaMetales);
        metalesGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!metalesEditText.getText().toString().isEmpty()) {
                    boolean cantidadGuardada = guardarCantidad(metalesEditText.getText().toString());
                    if (cantidadGuardada) {
                        Toast.makeText(getApplicationContext(), "Cantidad Guardada Con Exito", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Campo de Texto vacío", Toast.LENGTH_SHORT).show();
                }
            }
        });

        metalesBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                metalesEditText.setText("");
            }
        });

        Button volverMetales = findViewById(R.id.metales_volver_btn);
        final Intent intentVolverMetales = new Intent(this, CategoriasMenu.class);
        volverMetales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolverMetales);
            }
        });
    }

    private boolean guardarCantidad(String cantidad) {
        File fileMetales = new File(getFilesDir(), "metalesGuardados.txt");
        try {
            if (!fileMetales.exists()) {
                fileMetales.createNewFile();
            }
            FileWriter writer = new FileWriter(fileMetales, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);
            Metales metales = new Metales(Float.parseFloat(cantidad), fecha);
            String linea = String.format(Locale.getDefault(), "%.2f,%.2f,%s", metales.getCantidadMetales(), metales.getFechaMetales());
            bufferedWriter.write(linea);
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true; // La Cantidad se guardó correctamente

        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Error al guardar la cantidad
    }


}