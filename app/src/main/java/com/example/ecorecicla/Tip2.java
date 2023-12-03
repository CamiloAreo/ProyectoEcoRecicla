package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tip2 extends AppCompatActivity {

    private List<String> tipsList;
    private TextView tip2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_2);

        Button volver = findViewById(R.id.tip2_volver_btn);
        final Intent intent = new Intent(this, TipsMenu.class);

        tip2 = findViewById(R.id.tip2_mensaje_txt);
        tipsList = new ArrayList<>();

        leerTips();
        mostrarTip2Aleatorio();
    }

    private void mostrarTip2Aleatorio() {
        if (tipsList.isEmpty()) {
            tip2.setText("No hay consejos disponibles.");
            return;
        }

        Random random = new Random();
        int index = random.nextInt(tipsList.size());
        String tip = tipsList.get(index);
        tip2.setText(tip);
    }

    private void leerTips() {
        File file2 = new File(getFilesDir(), "tip2.txt");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file2));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                tipsList.add(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
