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

public class Tela3GastoPadraoInput extends AppCompatActivity {

    private EditText    ID3_Input_L_editView_NomeGasto;
    private EditText    ID3_Input_L_editView_ValorGasto;
    private DatePicker  ID3_Input_L_datePicker_DataGasto;

    private ImageButton ID3_Input_L_imageButton_Adicionar;

    Calendar calendar = Calendar.getInstance();

    BancoDeDados myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3_gasto_padrao_input);

        myDB = new BancoDeDados(this);

        ID3_Input_L_editView_NomeGasto      = findViewById(R.id.ID3_Input_L_editView_NomeGasto);
        ID3_Input_L_editView_ValorGasto     = findViewById(R.id.ID3_Input_L_editView_ValorGasto);
        ID3_Input_L_datePicker_DataGasto    = findViewById(R.id.ID3_Input_L_datePicker_DataGasto);

        ID3_Input_L_datePicker_DataGasto.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                System.out.println( String.format(Locale.US, "%d/%d/%d", dayOfMonth, monthOfYear, year) );
            }
        });

        ID3_Input_L_imageButton_Adicionar   = findViewById(R.id.ID3_Input_L_imageButton_Adicionar);

        ID3_Input_L_imageButton_Adicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nGasto = ID3_Input_L_editView_NomeGasto.getText().toString();
                String vGasto = ID3_Input_L_editView_ValorGasto.getText().toString();

                DatePicker dGasto = ID3_Input_L_datePicker_DataGasto;
                String data = dGasto.getDayOfMonth() + "/" + dGasto.getMonth() + "/" + dGasto.getYear();

                if(nGasto.length() != 0 && vGasto.length() != 0 && dGasto != null) {
                    AdicionarDado(nGasto, vGasto, data);
                    ID3_Input_L_editView_NomeGasto.setText("");
                    ID3_Input_L_editView_ValorGasto.setText("");
                } else {
                    Toast.makeText(Tela3GastoPadraoInput.this,"Todos os campos devem ser preenchidos!", Toast.LENGTH_LONG).show();
                }
                finish();
            }
        });
    }

    public void AdicionarDado(String nomeModelo, String valorModelo, String dataModelo) {

        boolean insertData = myDB.adicionarDado(nomeModelo, valorModelo, "-1", dataModelo);

        if(insertData){
            Toast.makeText(Tela3GastoPadraoInput.this,"Dados incluídos com sucesso!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(Tela3GastoPadraoInput.this,"Ops... Parace que algo deu errado, tente novamente mais tarde.", Toast.LENGTH_LONG).show();
        }
        fileList();
    }

}
