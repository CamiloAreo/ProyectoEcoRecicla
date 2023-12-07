package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ecorecicla.modelos.Vidrio;

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

public class VidrioCategoria extends AppCompatActivity {

    private TableLayout vidrioTableLayout;
    long ahora = System.currentTimeMillis();
    Date date = new Date(ahora);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
    String fecha = df.format(date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vidrio_categoria);

        Button vidrioGuardar = findViewById(R.id.vidrio_guardar_btn);
        Button vidrioBorrar = findViewById(R.id.vidrio_borrar_btn);
        EditText vidrioEditText = findViewById(R.id.vidrio_cantidad_txt);
        vidrioTableLayout = findViewById(R.id.vidrio_TableLayout);

        // Carga Archivo Vidrio
        File fileVidrio = new File(getFilesDir(), "vidrioGuardados.txt");

        // Lista de Vidrio
        List<Vidrio> listaVidrio = leerArchivoVidrio(fileVidrio);

        // Crear la Tabla Vidrio
        addVidrio(listaVidrio);

        vidrioGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!vidrioEditText.getText().toString().isEmpty()) {
                    boolean cantidadGuardada = guardarCantidad(fecha, vidrioEditText.getText().toString());
                    if (cantidadGuardada) {
                        Toast.makeText(getApplicationContext(), "Cantidad Guardada Con Exito", Toast.LENGTH_SHORT).show();
                        vidrioEditText.setText("");
                        int encabezado = 1;
                        int fin = vidrioTableLayout.getChildCount() - 1;
                        vidrioTableLayout.removeViews(encabezado, fin);
                        File fileVidrio = new File(getFilesDir(), "vidrioGuardados.txt");
                        List<Vidrio> listaVidrio = leerArchivoVidrio(fileVidrio);
                        addVidrio(listaVidrio);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error al Guardar", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Algunos campos están vacíos
                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        vidrioBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vidrioEditText.setText("");
            }
        });

        ImageButton volverVidrio = findViewById(R.id.vidrio_volver_btn);
        final Intent intentVolverVidrio = new Intent(this, CategoriasMenu.class);
        volverVidrio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolverVidrio);
            }
        });
    }

    private boolean guardarCantidad(String fecha, String cantidad) {
        File fileVidrio = new File(getFilesDir(), "vidrioGuardados.txt");
        try {
            if (!fileVidrio.exists()) {
                fileVidrio.createNewFile();
            }

            FileWriter writer = new FileWriter(fileVidrio, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Crear una instancia de Vidrio y escribir los datos en el archivo
            Vidrio vidrio = new Vidrio(fecha, Float.parseFloat(cantidad));
            String linea = vidrio.getFechaVidrio() + ", " + vidrio.getCantidadVidrio();
            bufferedWriter.write(linea);
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true; // La Cantidad se guardó correctamente
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Error al guardar la cantidad
    }

    private void addVidrio(List<Vidrio> listaVidrio) {
        for (Vidrio item : listaVidrio) {

            TableRow row = new TableRow(this);

            TextView cell1 = new TextView(this);
            cell1.setText(item.getFechaVidrio());
            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.verdeTabla);

            TextView cell2 = new TextView(this);
            cell2.setText(String.valueOf(item.getCantidadVidrio()));
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.verdeTabla);

            row.addView(cell1);
            row.addView(cell2);

            vidrioTableLayout.addView(row);
        }
    }

    private List<Vidrio> leerArchivoVidrio(File archivo) {
        List<Vidrio> listaVidrio = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String fecha = datos[0];
                float cantidad = Float.parseFloat(datos[1]);
                Vidrio vidrio = new Vidrio(fecha, cantidad);
                listaVidrio.add(vidrio);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaVidrio;
    }
}