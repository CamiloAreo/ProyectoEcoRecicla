package com.example.ecorecicla;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent inicialIntent = new Intent(this, InicioDeSesion.class);
        startActivity(inicialIntent);

        File fileDatos = new File(getFilesDir(), "datos.txt");
        if (!fileDatos.exists()) {
            try {
                FileWriter writer = new FileWriter(fileDatos);
                writer.append("root,root@root.com,toor,TOOR\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File fileCorreos = new File(getFilesDir(), "correosOlvidos.txt");
        if (!fileCorreos.exists()) {
            try {
                FileWriter writer = new FileWriter(fileCorreos);
                writer.append("root,root@root.com,toor,TOOR\n");
                writer.flush();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Tips 1
        File file1 = new File(getFilesDir(), "tip1.txt");
        try {
            FileWriter writer = new FileWriter(file1);

            // Lista de Tips 1
            String[] tips = {
                    "Separa los envases dependiendo de su material: plásticos, vidrio, aluminio o metal.",
                    "Reutiliza las bolsas de plástico, estas pueden usarse una y otra vez para cargar tus comprar en el mercado.",
                    "Los desechos orgánicos puedes reciclarlos, si tienes, en tu propia compostera para tus plantas."
            };
            // Recorrer el array y agregar los consejos al archivo
            writer.append("Separa/limpia la basura orgánica de los envases.\n");
            for (String tip : tips) {
                writer.append(tip).append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Tips 2
        File file2 = new File(getFilesDir(), "tip2.txt");
        try {
            FileWriter writer = new FileWriter(file2);

            // Lista de Tips 2
            String[] tips = {
                    "Limpia los envases plásticos antes de almacenarlos para evitar malos olores y una mejor disposición final.",
                    "Evita el contacto con material orgánico en descomposición; puede causar Hepatitis, Tétanos, Rabia, Leptospirosis, entre otros.",
                    "Protege tus vías respiratorias al tener contacto con recipientes que contengan líquidos con restos químicos",
                    "El aceite usado se debe disponer en sitios especializados. Consulta con la empresa recolectora de desechos de tu sector para más información"
            };
            // Recorrer el array y agregar los consejos al archivo
            writer.append("Protege tus manos al manipular elementos cortantes como vidrios o elementos filosos.\n");
            for (String tip : tips) {
                writer.append(tip).append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Tips 3
        File file3 = new File(getFilesDir(), "tip3.txt");
        try {
            FileWriter writer = new FileWriter(file3);

            // Lista de Tips 3
            String[] tips = {
                    "Los vidrios de las ventanas de los automóviles contienen plomo Por lo cual No puede mezclarse con el vidrio de botellas y otros objetos.",
                    "Las lámparas tanto incandescentes como de bajo consumo suelen considerarse no reciclables por su mezcla de materiales (plástico, metal, vidrio).",
                    "Los diferentes tipos de cintas adhesivas (aislante, de enmascarar, de embalar, americana) no pueden reciclarse. Están fabricadas a base de caucho sin tratar",
                    "El papel que se utiliza para imprimir faxes y para imprimir recibos de tarjeta de crédito no es reciclable porque es papel térmico"
            };
            // Recorrer el array y agregar los consejos al archivo
            writer.append("Las Fotos No pueden ser recicladas por la capa plástica que poseen.\n");
            for (String tip : tips) {
                writer.append(tip).append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Tips 4
        File file4 = new File(getFilesDir(), "tip4.txt");
        try {
            FileWriter writer = new FileWriter(file4);

            // Lista de Tips 4
            String[] tips = {
                    "Encuentre un lugar apropiado para almacenar los diferente tipos de residuos.",
                    "Reutilizar los productos que se quieren desechar, si aún están en buen estado y reutilizar el papel lo más que se pueda.",
                    "Evitar las bolsas desechables y llevar tus propias bolsas al mercado",
                    "Comprar material a empresas con programas de sostenibilidad y reciclaje.",
                    "Reciclar todo el vidrio o plástico que tenga, reciclar la ropa, donar juguetes, reciclar aparatos electrónicos y reciclar el papel."
            };
            // Recorrer el array y agregar los consejos al archivo
            writer.append("Recicle todo el vidrio o plástico que tenga.\n");
            for (String tip : tips) {
                writer.append(tip).append("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}