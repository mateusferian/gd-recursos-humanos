package br.com.geradordedevs.gdrecursoshumanos.controllers;


import javax.xml.crypto.Data;
import java.util.Date;

public class Colaborador {

    private int id;
    private String nome;
    private int idade;

    private Date dataDeNascimento;
    private TipoDocumento tipodocumento;
    private String numeroDocumento;

    private Cargo cargo;
    private Departamento departamento;
    private double salario;

    private Date dataInicio;
    private boolean ativo;
    private String telefone;
    private String email;

    public Colaborador(int id, String nome, int idade, Date dataDeNascimento, TipoDocumento tipodocumento, String numeroDocumento, Cargo cargo, Departamento departamento, double salario, Date dataInicio, boolean ativo, String telefone, String email) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.dataDeNascimento = dataDeNascimento;
        this.tipodocumento = tipodocumento;
        this.numeroDocumento = numeroDocumento;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.dataInicio = dataInicio;
        this.ativo = ativo;
        this.telefone = telefone;
        this.email = email;
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public TipoDocumento getTipodocumento() {
        return tipodocumento;
    }

    public void setTipodocumento(TipoDocumento tipodocumento) {
        this.tipodocumento = tipodocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
