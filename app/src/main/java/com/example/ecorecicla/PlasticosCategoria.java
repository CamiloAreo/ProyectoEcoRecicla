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

import com.example.ecorecicla.modelos.Plasticos;

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

public class PlasticosCategoria extends AppCompatActivity {

    private TableLayout plasticosTableLayout;
    long ahora = System.currentTimeMillis();
    Date date = new Date(ahora);
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy hh:mm a");
    String fecha = df.format(date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.plasticos_categoria);

        Button plasticosGuardar = findViewById(R.id.plasticos_guardar_btn);
        Button plasticosBorrar = findViewById(R.id.plasticos_borrar_btn);
        EditText plasticosEditText = findViewById(R.id.plasticos_cantidad_txt);
        plasticosTableLayout = findViewById(R.id.plasticos_TableLayout);

        // Carga Archivo Plasticos
        File filePlasticos = new File(getFilesDir(), "plasticosGuardados.txt");

        // Lista de Plasticos
        List<Plasticos> listaPlasticos = leerArchivoPlasticos(filePlasticos);

        // Crear la Tabla Papel
        addPlasticos(listaPlasticos);

        plasticosGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!plasticosEditText.getText().toString().isEmpty()) {
                    boolean cantidadGuardada = guardarCantidad(fecha, plasticosEditText.getText().toString());
                    if (cantidadGuardada) {
                        Toast.makeText(getApplicationContext(), "Cantidad Guardada Con Exito", Toast.LENGTH_SHORT).show();
                        plasticosEditText.setText("");
                        int encabezado = 1;
                        int fin = plasticosTableLayout.getChildCount() - 1;
                        plasticosTableLayout.removeViews(encabezado, fin);
                        File filePlasticos = new File(getFilesDir(), "plasticosGuardados.txt");
                        List<Plasticos> listaPlasticos = leerArchivoPlasticos(filePlasticos);
                        addPlasticos(listaPlasticos);
                    } else {
                        Toast.makeText(getApplicationContext(), "Error al Guardar", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Algunos campos están vacíos
                    Toast.makeText(getApplicationContext(), "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        plasticosBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plasticosEditText.setText("");
            }
        });

        ImageButton volverPlasticos = findViewById(R.id.plasticos_volver_btn);
        final Intent intentVolverPlasticos = new Intent(this, CategoriasMenu.class);
        volverPlasticos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolverPlasticos);
            }
        });
    }

    private boolean guardarCantidad(String fecha, String cantidad) {
        File filePlasticos = new File(getFilesDir(), "plasticosGuardados.txt");
        try {
            if (!filePlasticos.exists()) {
                filePlasticos.createNewFile();
            }

            FileWriter writer = new FileWriter(filePlasticos, true);
            BufferedWriter bufferedWriter = new BufferedWriter(writer);

            // Crear una instancia de Plasticos y escribir los datos en el archivo
            Plasticos plastico = new Plasticos(fecha, Float.parseFloat(cantidad));
            String linea = plastico.getFechaPlasticos() + ", " + plastico.getCantidadPlasticos();
            bufferedWriter.write(linea);
            bufferedWriter.newLine();
            bufferedWriter.close();
            return true; // La Cantidad se guardó correctamente
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Error al guardar la cantidad
    }

    private void addPlasticos(List<Plasticos> listaPlasticos) {
        for (Plasticos item : listaPlasticos) {

            TableRow row = new TableRow(this);

            TextView cell1 = new TextView(this);
            cell1.setText(item.getFechaPlasticos());
            cell1.setPadding(10, 10, 10, 10);
            cell1.setBackgroundResource(R.color.verdeTabla);

            TextView cell2 = new TextView(this);
            cell2.setText(String.valueOf(item.getCantidadPlasticos()));
            cell2.setPadding(10, 10, 10, 10);
            cell2.setBackgroundResource(R.color.verdeTabla);

            row.addView(cell1);
            row.addView(cell2);

            plasticosTableLayout.addView(row);
        }
    }

    private List<Plasticos> leerArchivoPlasticos(File archivo) {
        List<Plasticos> listaPlasticos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String fecha = datos[0];
                float cantidad = Float.parseFloat(datos[1]);
                Plasticos plastico = new Plasticos(fecha, cantidad);
                listaPlasticos.add(plastico);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaPlasticos;
    }
}