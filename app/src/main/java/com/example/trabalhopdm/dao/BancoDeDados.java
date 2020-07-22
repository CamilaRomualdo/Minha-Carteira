package com.example.trabalhopdm.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.trabalhopdm.entity.Modelo;

import java.util.ArrayList;

public class BancoDeDados extends SQLiteOpenHelper {
    public BancoDeDados(Context context) {
        super(context, "BANCO", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "CREATE TABLE NOME_DO_BANCO(NOME  TEXT," +
                " VALOR REAL, " +
                " PRESTACAO REAL, " +
                " DATA TEXT)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public boolean adicionarDado(String nomeModelo, String valorModelo, String numModelo, String dataModelo) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues registro = new ContentValues();
        registro.put("NOME", nomeModelo);
        registro.put("VALOR", valorModelo);
        registro.put("PRESTACAO", numModelo);
        registro.put("DATA", dataModelo);

        db.insert("NOME_DO_BANCO" , null, registro);

        return true;

    }

//    public void alterarDado(Modelo modelo){
//
//        SQLiteDatabase db = getWritableDatabase();
//
//        ContentValues registro = new ContentValues();
//        registro.put("NOME",modelo.getNomeModelo());
//        registro.put("VALOR",modelo.getValorModelo());
//        registro.put("PRESTACAO",modelo.getNumModelo());
//        registro.put("DATA",modelo.getDataModelo());
//
//        db.update("NOME_DO_BANCO" , registro, null, null);
//
//    }
//
//    public void apagarDado(Modelo modelo){
//
//        SQLiteDatabase db = getWritableDatabase();
//
//        db.delete("NOME_DO_BANCOB", null, null);
//    }

    public void carregarDadoGastoPadrao(ArrayList<Modelo> lista) {

        lista.clear();

        SQLiteDatabase db = getReadableDatabase();

        String colunas[] = new String[4];
        colunas[0] = "NOME"; colunas[1]="VALOR"; colunas[2] = "PRESTACAO"; colunas[3] = "DATA";

        /*
            É necessário criar uma condição para trazer todos os gastos da tabela que tiverem o campo PRESTACAO = -1
        */
        Cursor cursor;
        cursor = db.query("NOME_DO_BANCO",colunas,null,null,null,null,null);
        if(cursor==null) {
            return;
        } else {
            boolean proximo = cursor.moveToFirst();
            while (proximo){
                String nome = cursor.getString(0);
                String valor   = cursor.getString(1);
                String prestacao  = cursor.getString(2);
                String data  = cursor.getString(3);
                Modelo m = new Modelo(nome, valor, prestacao, data);
                lista.add(m);
                proximo = cursor.moveToNext();
            }
        }
    }

    public void carregarDadoPrestacao(ArrayList<Modelo> lista) {
        lista.clear();
        SQLiteDatabase db = getReadableDatabase();

        String colunas[] = new String[4];
        colunas[0] = "NOME"; colunas[1]="VALOR"; colunas[2] = "PRESTACAO"; colunas[3] = "DATA";

        /*
            É necessário criar uma condição para trazer todos os gastos do tabela que tiverem o campo PRESTACAO <> -1
        */
        Cursor cursor;
        cursor = db.query("NOME_DO_BANCO",colunas,null,null,null,null,null);
        if(cursor==null) {
            return;
        } else {
            boolean proximo = cursor.moveToFirst();
            while (proximo){
                String nome = cursor.getString(0);
                String valor   = cursor.getString(1);
                String prestacao  = cursor.getString(2);
                String data  = cursor.getString(3);
                Modelo m = new Modelo(nome, valor, prestacao, data);
                lista.add(m);
                proximo = cursor.moveToNext();
            }
        }
    }

    public void limparBanco(){

        SQLiteDatabase db = getWritableDatabase();

        db.delete("NOME_DO_BANCO",null,null);
    }

}
