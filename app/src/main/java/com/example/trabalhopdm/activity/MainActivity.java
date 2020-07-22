package com.example.trabalhopdm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.trabalhopdm.R;

public class MainActivity extends AppCompatActivity {

    private ImageView telaAnalise;
    private ImageView telaColaboradores;
    private ImageView telaGastoPadrao;
    private ImageView telaGastoPrestacao;
    private ImageView telaRequisitos;
    private ImageView telaSobreProjeto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        telaAnalise          = findViewById(R.id.ID0_imageView_Analise);
        telaColaboradores    = findViewById(R.id.ID0_imageView_Colaboradores);
        telaGastoPadrao      = findViewById(R.id.ID0_imageView_GastoPadrao);
        telaGastoPrestacao   = findViewById(R.id.ID0_imageView_GastoPrestacao);
        telaRequisitos       = findViewById(R.id.ID0_imageView_Requisitos);
        telaSobreProjeto     = findViewById(R.id.ID0_imageView_SobreProjeto);

        telaAnalise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTela1Analise();
            }
        });

        telaColaboradores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTela2Colaboradores();
            }
        });

        telaGastoPadrao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTela3GastoPadrao();
            }
        });

        telaGastoPrestacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTela4GastoPrestacao();
            }
        });

        telaRequisitos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTela5Requisitos();
            }
        });

        telaSobreProjeto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTela6SobreProjeto();
            }
        });

    }

    public void openTela1Analise() {
        Intent intent = new Intent(this, Tela1Analise.class);
        startActivity(intent);
    }

    public void openTela2Colaboradores() {
        Intent intent = new Intent(this, Tela2Colaboradores.class);
        startActivity(intent);
    }

    public void openTela3GastoPadrao() {
        Intent intent = new Intent(this, Tela3GastoPadrao.class);
        startActivity(intent);
    }

    public void openTela4GastoPrestacao() {
        Intent intent = new Intent(this, Tela4GastoPrestacao.class);
        startActivity(intent);
    }

    public void openTela5Requisitos() {
        Intent intent = new Intent(this, Tela5Requisitos.class);
        startActivity(intent);
    }

    public void openTela6SobreProjeto() {
        Intent intent = new Intent(this, Tela6SobreProjeto.class);
        startActivity(intent);
    }

}
