package com.example.ecorecicla;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class TipsMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tips_menu);

        Button tip1 = findViewById(R.id.tip1_btn);
        final Intent intentTip1 = new Intent(this, Tip1.class);
        tip1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentTip1);
            }
        });

        Button tip2 = findViewById(R.id.tip2_btn);
        final Intent intentTip2 = new Intent(this, Tip2.class);
        tip2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentTip2);
            }
        });

        Button tip3 = findViewById(R.id.tip3_btn);
        final Intent intentTip3 = new Intent(this, Tip3.class);
        tip3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentTip3);
            }
        });

        Button tip4 = findViewById(R.id.tip4_btn);
        final Intent intentTip4 = new Intent(this, Tip4.class);
        tip4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentTip4);
            }
        });

        ImageButton volver = findViewById(R.id.tips_volver_btn);
        final Intent intentVolver = new Intent(this, PantallaPrincipal.class);
        volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intentVolver);
            }
        });

    }
}
