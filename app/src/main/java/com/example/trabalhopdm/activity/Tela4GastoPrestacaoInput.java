package com.example.trabalhopdm.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.trabalhopdm.R;
import com.example.trabalhopdm.dao.BancoDeDados;

import java.util.Calendar;
import java.util.Locale;

public class Tela4GastoPrestacaoInput extends AppCompatActivity {

    private EditText    ID4_Input_L_editView_NomePrestacao;
    private EditText    ID4_Input_L_editView_ValorPrestacao;
    private EditText    ID4_Input_L_editView_NumeroPrestacao;
    private DatePicker  ID4_Input_L_datePicker_DataMensalPrestacao;

    private ImageButton ID4_Input_L_imageButton_Adicionar;

    Calendar calendar = Calendar.getInstance();

    BancoDeDados myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4_gasto_prestacao_input);

        myDB = new BancoDeDados(this);

        ID4_Input_L_editView_NomePrestacao          = findViewById(R.id.ID4_Input_L_editView_NomePrestacao);
        ID4_Input_L_editView_ValorPrestacao         = findViewById(R.id.ID4_Input_L_editView_ValorPrestacao);
        ID4_Input_L_editView_NumeroPrestacao        = findViewById(R.id.ID4_Input_L_editView_NumeroPrestacao);
        ID4_Input_L_datePicker_DataMensalPrestacao  = findViewById(R.id.ID4_Input_L_datePicker_DataMensalPrestacao);

        ID4_Input_L_datePicker_DataMensalPrestacao.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                System.out.println( String.format(Locale.US, "%d/%d/%d", dayOfMonth, monthOfYear, year) );
            }
        });

        ID4_Input_L_imageButton_Adicionar   = findViewById(R.id.ID4_Input_L_imageButton_Adicionar);

        ID4_Input_L_imageButton_Adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nPrestacao   = ID4_Input_L_editView_NomePrestacao.getText().toString();
                String vPrestacao   = ID4_Input_L_editView_ValorPrestacao.getText().toString();
                String numPrestacao = ID4_Input_L_editView_NumeroPrestacao.getText().toString();

                DatePicker dPrestacao = ID4_Input_L_datePicker_DataMensalPrestacao;
                String data = dPrestacao.getDayOfMonth() + "/" + dPrestacao.getMonth() + "/" + dPrestacao.getYear();

                if(nPrestacao.length() != 0 && vPrestacao.length() != 0 && numPrestacao.length() != 0 && dPrestacao != null) {
                    AdicionarDado(nPrestacao, vPrestacao, numPrestacao, data);
                    ID4_Input_L_editView_NomePrestacao.setText("");
                    ID4_Input_L_editView_ValorPrestacao.setText("");
                    ID4_Input_L_editView_NumeroPrestacao.setText("");
                } else {
                    Toast.makeText(Tela4GastoPrestacaoInput.this,"Todos os campos devem ser preenchidos!", Toast.LENGTH_LONG).show();
                }
                finish();
            }
        });
    }

    public void AdicionarDado(String nomeModelo, String valorModelo, String numModelo, String dataModelo) {

        boolean insertData = myDB.adicionarDado(nomeModelo, valorModelo, numModelo, dataModelo);

        if(insertData){
            Toast.makeText(Tela4GastoPrestacaoInput.this,"Dados incluídos com sucesso!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Tela4GastoPrestacaoInput.this,"Ops... Parace que algo deu errado, tente novamente mais tarde.", Toast.LENGTH_LONG).show();
        }
        fileList();
    }

}
