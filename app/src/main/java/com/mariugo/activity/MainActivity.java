package com.mariugo.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText inserirNome;
    CheckBox brasileiro, italiano, espanhol;
    RatingBar avaliacao;
    FloatingActionButton botao;
    TextView sexo;
    List<String> cidadania = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inserirNome = findViewById(R.id.textInputEditText);
        brasileiro = findViewById(R.id.checkboxBrasileiro);
        italiano = findViewById(R.id.checkBoxItaliano);
        espanhol = findViewById(R.id.checkBoxEspanhol);
        avaliacao = findViewById(R.id.ratingBar);
        botao = findViewById(R.id.fbNext);
        sexo = findViewById(R.id.tvResSexo);

        botao.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Activity2.class);
            intent.putExtra("nomeUsuario", inserirNome.getText().toString());
            intent.putExtra("cidadania", cidadania.toString());
            intent.putExtra("avaliacao", avaliacao.getRating());
            startActivity(intent);
        });
    }

    public void checarBox(View v) {
        if (brasileiro.isChecked()) {
            cidadania.add(brasileiro.getText().toString());
        }
        if (italiano.isChecked()) {
            cidadania.add(italiano.getText().toString());
        }
        if (espanhol.isChecked()) {
            cidadania.add(espanhol.getText().toString());
        }
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Intent intent = getIntent();
        sexo.setText(intent.getStringExtra("sexo"));
    }
}