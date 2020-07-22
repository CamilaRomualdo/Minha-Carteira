package com.example.trabalhopdm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.trabalhopdm.entity.Modelo;
import com.example.trabalhopdm.R;
import com.example.trabalhopdm.dao.BancoDeDados;

import java.util.ArrayList;

public class Tela4GastoPrestacao extends AppCompatActivity {

    private ImageButton adicionarGasto;
    private TextView limparGasto;

    private ListView             ID4_listView_Prestracao;
    private ArrayList<Modelo>    modeloLista = new ArrayList<Modelo>();
    private ArrayAdapter<Modelo> listaArrayAdapter;

    private Intent               Tela4GastoPadraoDetails;

    BancoDeDados myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4_gasto_prestacao);
        myDB = new BancoDeDados(this);

        Tela4GastoPadraoDetails = new Intent(this, Tela4GastoPrestacaoDetails.class);

        inicializaComponentes();
        inicializaListeners();

        ////////////////////////////////////////////////////////////////////////////////////////////
        adicionarGasto = findViewById(R.id.ID4_imageButton_Adicionar);

        adicionarGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTelaDeGastoPrestacao();
            }
        });

        limparGasto = findViewById(R.id.ID4_textView_GP_Limpar);

        limparGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                modeloLista.clear();
                listaArrayAdapter.clear();
                listaArrayAdapter.notifyDataSetChanged();
                myDB.limparBanco();
            }
        });

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void openTelaDeGastoPrestacao() {
        Intent intent = new Intent(this, Tela4GastoPrestacaoInput.class);
        startActivity(intent);
    }

    public void inicializaComponentes(){

        ID4_listView_Prestracao = findViewById(R.id.ID4_listView_Prestracao);
        listaArrayAdapter       = new ArrayAdapter<Modelo>(this,
                android.R.layout.simple_expandable_list_item_1,
                modeloLista);
        ID4_listView_Prestracao.setAdapter(listaArrayAdapter);

    }

    public void inicializaListeners(){
        myDB.carregarDadoPrestacao(modeloLista);
        listaArrayAdapter.notifyDataSetChanged();

        ID4_listView_Prestracao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle details = new Bundle();
                Modelo modelo = modeloLista.get(position);
                details.putString("nome", modelo.getNomeModelo());
                details.putString("valor", modelo.getValorModelo());
                details.putString("pretacao", modelo.getNumModelo());
                details.putString("data", modelo.getDataModelo());
                Tela4GastoPadraoDetails.putExtras(details);
                startActivity(Tela4GastoPadraoDetails);
            }
        });
    }
}
