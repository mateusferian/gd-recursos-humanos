package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorRequestDTO {

    private String nome;
    private int idade;
    private Date dataDeNascimento;
    private Long tipoDucumentoId;
    private String numeroDocumento;
    private Long cargoId;
    private Long departamentoId;
    private double salario;
    private Date dataInicio;
    private boolean ativo;
    private String telefone;
    private String email;
}
