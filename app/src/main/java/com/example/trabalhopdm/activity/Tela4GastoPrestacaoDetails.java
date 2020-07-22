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

public class Tela4GastoPrestacaoDetails extends AppCompatActivity {

    private TextView  ID3_Details_L_textView_NomePrestacao;
    private TextView  ID4_Details_L_textView_ValorPrestacao;
    private TextView  ID4_Details_L_textView_NumeroPrestacao;
    private TextView  ID4_Details_L_textView_DataPrestacao;

    private TextView  ID4_Details_L_textView_Alterar;
    private TextView  ID4_Details_L_textView_Apagar;

    private ImageView ID4_Details_L_imageView_EnviarEmail;

    private Intent shareIntent;

//    BancoDeDados myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4_gasto_prestacao_details);

        ID3_Details_L_textView_NomePrestacao   = findViewById(R.id.ID3_Details_L_textView_NomePrestacao);
        ID4_Details_L_textView_ValorPrestacao  = findViewById(R.id.ID4_Details_L_textView_ValorPrestacao);
        ID4_Details_L_textView_NumeroPrestacao = findViewById(R.id.ID4_Details_L_textView_NumeroPrestacao);
        ID4_Details_L_textView_DataPrestacao   = findViewById(R.id.ID4_Details_L_textView_DataPrestacao);

        ID4_Details_L_imageView_EnviarEmail    = findViewById(R.id.ID4_Details_L_imageView_EnviarEmail);

        Intent it = getIntent();
        Bundle details = it.getExtras();
        String nome = details.getString("nome");
        String valor = details.getString("valor");
        String numPrestacao = details.getString("pretacao");
        String data = details.getString("data");

        final Modelo modelo = new Modelo(nome, valor, null, data);

        ID3_Details_L_textView_NomePrestacao.setText(nome);
        ID4_Details_L_textView_ValorPrestacao.setText(valor);
        ID4_Details_L_textView_NumeroPrestacao.setText(numPrestacao);
        ID4_Details_L_textView_DataPrestacao.setText(data);

        ID4_Details_L_imageView_EnviarEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                StringBuilder detail = new StringBuilder();
                detail.append("Detalhes referente ao meu Gasto à Prestação - Minha Carteira\n");
                detail.append("Nome: ");
                detail.append(modelo.getNomeModelo()+ "\n");
                detail.append("Valor: ");
                detail.append(modelo.getValorModelo()+ "\n");
                detail.append("Quantidade de Prestações: ");
                detail.append(modelo.getNumModelo()+ "\n");
                detail.append("Data mensal da prestação: ");
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
//        ID4_Details_L_textView_Alterar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Modelo modelo = obterModelo();
//                myDb.alterarDado(modelo);
//            }
//        });
//        ID4_Details_L_textView_Apagar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Modelo modelo = obterModelo();
//                myDb.apagarDado(modelo);
//            }
//        });
//    }
//
//    private Modelo obterModelo(){
//        String nome       = ID4_Details_L_textView_NomeGasto.getText().toString();
//        String valor      = ID4_Details_L_textView_ValorGasto.getText().toString();
//        String pretacao   = ID4_Details_L_textView_NumeroPrestacao.getText().toString();
//        String data       = ID4_Details_L_textView_DataGasto.getText().toString();
//        Modelo modelo     = new Modelo(nome, valor, pretacao, data);
//        return modelo;
//    }

}
