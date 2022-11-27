package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.controllers.Colaborador;

import java.util.Date;

public class Atestado {
    private int id;
    private String nome;
    private Date data;
    private Colaborador colaborador;

    public Atestado(int id, String nome, Date data, Colaborador colaborador) {
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.colaborador = colaborador;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}



