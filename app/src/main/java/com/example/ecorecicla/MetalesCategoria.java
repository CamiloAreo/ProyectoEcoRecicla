package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MetalesCategoria extends AppCompatActivity {

    private TableLayout metalesTableLayout;
    long ahora = System.currentTimeMillis();
    Date date = new Date(ahora);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
    String fecha = df.format(date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metales_categoria);

        Button metalesGuardar = findViewById(R.id.metales_guardar_btn);
        Button metalesBorrar = findViewById(R.id.metales_borrar_btn);
        EditText metalesEditText = findViewById(R.id.metales_cantidad_txt);
        metalesTableLayout = findViewById(R.id.Metales_TableLayout);

        // Carga Archivo Metales
        File fileMetales = new File(getFilesDir(), "metalesGuardados.txt");

        // Lista de Metales
        List<Metales> listaMetales = leerArchivoMetales(fileMetales);

        // Crear la Tabla Metales
        addMetal(listaMetales);

        metalesGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!metalesEditText.getText().toString().isEmpty()) {
                    boolean cantidadGuardada = guardarCantidad(fecha, metalesEditText.getText().toString());
                    if (cantidadGuardada) {
                        Toast.makeText(getApplicationContext(), "Cantidad Guardada Con Exito", Toast.LENGTH_SHORT).show();
                        // PENDIENTE RECUPERAR ENCABEZADO
                        metalesTableLayout.removeAllViews();
                        File fileMetales = new File(getFilesDir(), "metalesGuardados.txt");
                        List<Metales> listaMetales = leerArchivoMetales(fileMetales);
                        addMetal(listaMetales);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error al Guardar", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Algunos campos están vacíos
                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
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

    private List<Metales> leerArchivoMetales(File archivo) {
        List<Metales> listaMetales = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String fecha = datos[0];
                float cantidad = Float.parseFloat(datos[1]);

                Metales metal = new Metales(fecha, cantidad);
                listaMetales.add(metal);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaMetales;
    }

    private void addMetal(List<Metales> listaMetales) {
        for (Metales item : listaMetales) {

            TableRow row = new TableRow(this);

            TextView cell1 = new TextView(this);
            cell1.setText(item.getFechaMetales());
            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.verdeTabla);

            TextView cell2 = new TextView(this);
            cell2.setText(String.valueOf(item.getCantidadMetales()));
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.verdeTabla);

            row.addView(cell1);
            row.addView(cell2);

            metalesTableLayout.addView(row);
        }
    }

    private boolean guardarCantidad(String fecha, String cantidad) {
        File fileMetales = new File(getFilesDir(), "metalesGuardados.txt");
        try {
            if (!fileMetales.exists()) {
                fileMetales.createNewFile();
            }

            FileWriter writer = new FileWriter(fileMetales, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Crear una instancia de Metales y escribir los datos en el archivo
            Metales metal = new Metales(fecha, Float.parseFloat(cantidad));
            String linea = metal.getFechaMetales() + ", " + metal.getCantidadMetales();
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