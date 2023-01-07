package br.com.geradordedevs.gdrecursoshumanos.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorResponseDTO {

    private Long id;
    private String nome;
    private int idade;
    private Date dataDeNascimento;
    private TipoDocumentoResponseDTO tipoDocumento;
    private String numeroDocumento;
    private CargoResponseDTO cargo;
    private DepartamentoResponseDTO departamento;
    private double salario;
    private Date dataInicio;
    private boolean ativo;
    private String telefone;
    private String email;

}
