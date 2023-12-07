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

import com.example.ecorecicla.modelos.Papel;

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

public class PapelCategoria extends AppCompatActivity {

    private TableLayout papelTableLayout;
    long ahora = System.currentTimeMillis();
    Date date = new Date(ahora);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
    String fecha = df.format(date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.papel_categoria);

        Button papelGuardar = findViewById(R.id.papel_guardar_btn);
        Button papelBorrar = findViewById(R.id.papel_borrar_btn);
        EditText papelEditText = findViewById(R.id.papel_cantidad_txt);
        papelTableLayout = findViewById(R.id.papel_TableLayout);

        // Carga Archivo Papel
        File filePapel = new File(getFilesDir(), "papelGuardados.txt");

        // Lista de Papel
        List<Papel> listaPapel = leerArchivoPapel(filePapel);

        // Crear la Tabla Papel
        addPapel(listaPapel);

        papelGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!papelEditText.getText().toString().isEmpty()) {
                    boolean cantidadGuardada = guardarCantidad(fecha, papelEditText.getText().toString());
                    if (cantidadGuardada) {
                        Toast.makeText(getApplicationContext(), "Cantidad Guardada Con Exito", Toast.LENGTH_SHORT).show();
                        papelEditText.setText("");
                        int encabezado = 1;
                        int fin = papelTableLayout.getChildCount() - 1;
                        papelTableLayout.removeViews(encabezado, fin);
                        File filePapel = new File(getFilesDir(), "papelGuardados.txt");
                        List<Papel> listaPapel = leerArchivoPapel(filePapel);
                        addPapel(listaPapel);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error al Guardar", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Algunos campos están vacíos
                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        papelBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                papelEditText.setText("");
            }
        });

        ImageButton volverPapel = findViewById(R.id.papel_volver_btn);
        final Intent intentVolverPapel = new Intent(this, CategoriasMenu.class);
        volverPapel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolverPapel);
            }
        });
    }

    private boolean guardarCantidad(String fecha, String cantidad) {
        File filePapel = new File(getFilesDir(), "papelGuardados.txt");
        try {
            if (!filePapel.exists()) {
                filePapel.createNewFile();
            }

            FileWriter writer = new FileWriter(filePapel, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Crear una instancia de Papel y escribir los datos en el archivo
            Papel papel = new Papel(fecha, Float.parseFloat(cantidad));
            String linea = papel.getFechaPapel() + ", " + papel.getCantidadPapel();
            bufferedWriter.write(linea);
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true; // La Cantidad se guardó correctamente
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Error al guardar la cantidad
    }

    private void addPapel(List<Papel> listaPapel) {
        for (Papel item : listaPapel) {

            TableRow row = new TableRow(this);

            TextView cell1 = new TextView(this);
            cell1.setText(item.getFechaPapel());
            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.verdeTabla);

            TextView cell2 = new TextView(this);
            cell2.setText(String.valueOf(item.getCantidadPapel()));
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.verdeTabla);

            row.addView(cell1);
            row.addView(cell2);

            papelTableLayout.addView(row);
        }
    }

    private List<Papel> leerArchivoPapel(File archivo) {
        List<Papel> listaPapel = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String fecha = datos[0];
                float cantidad = Float.parseFloat(datos[1]);
                Papel papel = new Papel(fecha, cantidad);
                listaPapel.add(papel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPapel;
    }
}