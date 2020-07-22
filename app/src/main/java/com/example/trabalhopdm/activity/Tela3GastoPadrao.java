package com.example.trabalhopdm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.ParseException;
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

public class Tela3GastoPadrao extends AppCompatActivity {

    private ImageButton adicionarGasto;
    private TextView limparGasto;

    private ListView             ID3_listView_GastoPadrao;
    private ArrayList<Modelo>    modeloLista = new ArrayList<Modelo>();
    private ArrayAdapter<Modelo> listaArrayAdapter;

    private Intent               Tela3GastoPadraoDetails;

    BancoDeDados myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) throws ParseException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3_gasto_padrao);
        myDB = new BancoDeDados(this);

        Tela3GastoPadraoDetails = new Intent(this, Tela3GastoPadraoDetails.class);

        inicializaComponentes();
        inicializaListeners();

        ////////////////////////////////////////////////////////////////////////////////////////////
        adicionarGasto = findViewById(R.id.ID3_imageButton_Adicionar);

        adicionarGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTelaDeGastoPadrao();
            }
        });

        limparGasto = findViewById(R.id.ID3_textView_GP_Limpar);

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
    public void openTelaDeGastoPadrao() {
        Intent intent = new Intent(this, Tela3GastoPadraoInput.class);
        startActivity(intent);
    }

    public void inicializaComponentes(){

        ID3_listView_GastoPadrao = findViewById(R.id.ID3_listView_GastoPadrao);
        listaArrayAdapter        = new ArrayAdapter<Modelo>(this,
                android.R.layout.simple_expandable_list_item_1,
                modeloLista);
        ID3_listView_GastoPadrao.setAdapter(listaArrayAdapter);
    }

    public void inicializaListeners(){
        myDB.carregarDadoGastoPadrao(modeloLista);
        listaArrayAdapter.notifyDataSetChanged();

        ID3_listView_GastoPadrao.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Bundle details = new Bundle();
                Modelo modelo = modeloLista.get(position);
                details.putString("nome", modelo.getNomeModelo());
                details.putString("valor", modelo.getValorModelo());
                details.putString("data", modelo.getDataModelo());
                Tela3GastoPadraoDetails.putExtras(details);
                startActivity(Tela3GastoPadraoDetails);
            }
        });
    }
}
