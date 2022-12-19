package br.com.geradordedevs.gdrecursoshumanos.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nome;
    private int idade;
    private Date dataDeNascimento;
    @ManyToOne
    private TipoDocumentoEntity tipoDocumento;
    private String numeroDocumento;
    @ManyToOne
    private CargoEntity cargo;
    @ManyToOne
    private DepartamentoEntity departamento;
    private double salario;

    private Date dataInicio;
    private boolean ativo;
    private String telefone;
    private String email;

    public ColaboradorEntity(Long id) {
        this.id = id;
    }

    public ColaboradorEntity(String nome, int idade, Date dataDeNascimento, TipoDocumentoEntity tipoDocumento, String numeroDocumento, CargoEntity cargo, DepartamentoEntity departamento, double salario, Date dataInicio, boolean ativo, String telefone, String email) {
        this.nome = nome;
        this.idade = idade;
        this.dataDeNascimento = dataDeNascimento;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.cargo = cargo;
        this.departamento = departamento;
        this.salario = salario;
        this.dataInicio = dataInicio;
        this.ativo = ativo;
        this.telefone = telefone;
        this.email = email;
    }
}
