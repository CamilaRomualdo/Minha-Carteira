package com.example.trabalhopdm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.trabalhopdm.dao.BancoDeDados;
import com.example.trabalhopdm.entity.Modelo;
import com.example.trabalhopdm.R;

public class Tela3GastoPadraoDetails extends AppCompatActivity {

    private TextView  ID3_Details_L_textView_NomeGasto;
    private TextView  ID3_Details_L_textView_ValorGasto;
    private TextView  ID3_Details_L_textView_DataGasto;

//    private TextView  ID3_Details_L_textView_Alterar;
//    private TextView  ID3_Details_L_textView_Apagar;

    private ImageView ID3_Details_L_imageView_EnviarEmail;

    private Intent shareIntent;

//    BancoDeDados myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3_gasto_padrao_details);

        ID3_Details_L_textView_NomeGasto  = findViewById(R.id.ID3_Details_L_textView_NomeGasto);
        ID3_Details_L_textView_ValorGasto = findViewById(R.id.ID3_Details_L_textView_ValorGasto);
        ID3_Details_L_textView_DataGasto  = findViewById(R.id.ID3_Details_L_textView_DataGasto);

        ID3_Details_L_imageView_EnviarEmail = findViewById(R.id.ID3_Details_L_imageView_EnviarEmail);

        Intent it = getIntent();
        Bundle details = it.getExtras();
        String nome = details.getString("nome");
        String valor = details.getString("valor");
        String data = details.getString("data");

        final Modelo modelo = new Modelo(nome, valor, null, data);

        ID3_Details_L_textView_NomeGasto.setText(nome);
        ID3_Details_L_textView_ValorGasto.setText(valor);
        ID3_Details_L_textView_DataGasto.setText(data);

        ID3_Details_L_imageView_EnviarEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                StringBuilder detail = new StringBuilder();
                detail.append("Detalhes referente ao meu Gasto Padrão - Minha Carteira\n");
                detail.append("Nome: ");
                detail.append(modelo.getNomeModelo()+ "\n");
                detail.append("Valor: ");
                detail.append(modelo.getValorModelo()+ "\n");
                detail.append("Data: ");
                detail.append(modelo.getDataModelo()+ "\n");

                shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                shareIntent.putExtra(Intent.EXTRA_SUBJECT, "Minha Carteira");
                shareIntent.putExtra(Intent.EXTRA_TEXT, detail.toString());
                startActivity(Intent.createChooser(shareIntent, "Compartilhar"));
            }
        });

    }

//    private void inicializaListeners(){
//        ID3_Details_L_textView_Alterar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Modelo modelo = obterModelo();
//                myDb.alterarDado(modelo);
//            }
//        });
//        ID3_Details_L_textView_Apagar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Modelo modelo = obterModelo();
//                myDb.apagarDado(modelo);
//            }
//        });
//    }
//
//    private Modelo obterModelo(){
//        String nome     = ID3_Details_L_textView_NomeGasto.getText().toString();
//        String valor    = ID3_Details_L_textView_ValorGasto.getText().toString();
//        String data     = ID3_Details_L_textView_DataGasto.getText().toString();
//        Modelo modelo   = new Modelo(nome, valor, data);
//        return modelo;
//    }

}
