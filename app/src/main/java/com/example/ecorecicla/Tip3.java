package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

public class Tip3 extends AppCompatActivity {
    private List<String> tipsList;
    private TextView tip3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tip_3);

        Button volver = findViewById(R.id.tip3_volver_btn);
        final Intent intent = new Intent(this, TipsMenu.class);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });

        tip3 = findViewById(R.id.tip3_mensaje_txt);
        tipsList = new ArrayList<>();

        leerTips();
        mostrarTipAleatorio();
    }

    private void mostrarTipAleatorio() {
        if (tipsList.isEmpty()) {
            tip3.setText("No hay consejos disponibles.");
            return;
        }

        Random random = new Random();
        int index = random.nextInt(tipsList.size());
        String tip = tipsList.get(index);
        tip3.setText(tip);
    }

    private void leerTips() {
        File file = new File(getFilesDir(), "tip3.txt");

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
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
