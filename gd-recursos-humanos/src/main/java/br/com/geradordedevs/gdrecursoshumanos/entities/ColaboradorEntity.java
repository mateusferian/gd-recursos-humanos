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
    private TipoDocumentoEntity tipoDucumento;
    private String numeroDocumento;
    @ManyToOne
    private CargoEntity cargoEntity;
    @ManyToOne
    private DepartamentoEntity departamentoEntity;
    private double salario;

    private Date dataInicio;
    private boolean ativo;
    private String telefone;
    private String email;
}
