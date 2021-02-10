package com.mariugo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Activity3 extends AppCompatActivity {

    RadioGroup escolhaSexo;
    TextView sexoEscolhido;
    String sexo = "";
    FloatingActionButton homeButton;
    Button confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        homeButton = findViewById(R.id.fbHome);
        escolhaSexo = findViewById(R.id.rgSexo);
        sexoEscolhido = findViewById(R.id.tvSexoEscolhido);
        confirmar = findViewById(R.id.btnConfirmar);

        escolhaSexo.setOnCheckedChangeListener((group, checkedId) -> {
            if (checkedId == R.id.rbMasculino) {
                sexo = "Masculino";
            }
            if (checkedId == R.id.rbFeminino) {
                sexo = "Feminino";
            }
            if (checkedId == R.id.rbOutro) {
                sexo = "Outro";
            }
        });

        confirmar.setOnClickListener(v -> sexoEscolhido.setText(sexo));


        homeButton.setOnClickListener(v -> {
            Intent intent = new Intent(Activity3.this, MainActivity.class);
            intent.putExtra("sexo", sexo);
            startActivity(intent);
        });
    }


}