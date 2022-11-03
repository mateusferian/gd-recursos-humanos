package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.controllers.Colaborador;

public class Atestado {
    private int id;
    private String nome;
    //data
    private Colaborador colaborador;

    public Atestado(int id, String nome, Colaborador colaborador) {
        this.id = id;
        this.nome = nome;
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

    public Colaborador getColaborador() {
        return colaborador;
    }

    public void setColaborador(Colaborador colaborador) {
        this.colaborador = colaborador;
    }
}



