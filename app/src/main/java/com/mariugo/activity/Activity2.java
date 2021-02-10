package com.mariugo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Activity2 extends AppCompatActivity {

    TextView nomeUsuario, cidadania, avaliacao;
    String _nomeUsuario, _cidadania;
    FloatingActionButton botao;
    float _avaliacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        nomeUsuario = findViewById(R.id.tvNomeUsuario);
        cidadania = findViewById(R.id.tvCidadania);
        avaliacao = findViewById(R.id.tvAvaliacao);
        botao = findViewById(R.id.fbNext2);

        Bundle bundle = getIntent().getExtras();

        if (!bundle.isEmpty()) {
            _nomeUsuario = bundle.getString("nomeUsuario");
            nomeUsuario.setText(_nomeUsuario);

            _cidadania = bundle.getString("cidadania");
            cidadania.setText(_cidadania);

            _avaliacao = bundle.getFloat("avaliacao");
            avaliacao.setText(String.format("%f", _avaliacao));
        } else {
            Toast.makeText(this, "Erro de troca de activity", Toast.LENGTH_SHORT).show();
        }

        botao.setOnClickListener(v -> {
            Intent intent = new Intent(Activity2.this, Activity3.class);
            startActivity(intent);
        });
    }
}