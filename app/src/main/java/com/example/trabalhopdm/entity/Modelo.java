package com.example.trabalhopdm.entity;

import java.util.Date;

public class Modelo {

    private String nomeModelo;
    private String valorModelo;
    private String numModelo;
    private String dataModelo;

    public Modelo(String nomeModelo, String valorModelo, String dataModelo) {
        this.nomeModelo = nomeModelo;
        this.valorModelo = valorModelo;
        this.dataModelo = dataModelo;
    }

    public Modelo(String nomeModelo, String valorModelo, String numModelo, String dataModelo) {
        this.nomeModelo = nomeModelo;
        this.valorModelo = valorModelo;
        this.numModelo = numModelo;
        this.dataModelo = dataModelo;
    }

    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public String getValorModelo() {
        return valorModelo;
    }

    public void setValorModelo(String valorModelo) {
        this.valorModelo = valorModelo;
    }

    public String getNumModelo() {
        return numModelo;
    }

    public void setNumModelo(String numModelo) {
        this.numModelo = numModelo;
    }

    public String getDataModelo() {
        return dataModelo;
    }

    public void setDataModelo(String dataModelo) {
        this.dataModelo = dataModelo;
    }

    public String toString() {
        return nomeModelo;
    }
}
