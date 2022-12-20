package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ColaboradorRequestDTO {
    private Long id;

    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 3,max = 40, message = "{tamanho.invalido}")
    private String nome;

    @Min(value = 18, message = "{idade.abaixo.do.minimo}")
    @Max(value = 70, message = "{idade.acima.do.maximo}")
    private int idade;

    @NotNull(message = "{campo.nulo}")
    private Date dataDeNascimento;

    @NotNull(message = "{campo.nulo}")
    @Min(value = 1, message = "{idade.abaixo.do.minimo}")
    private Long tipoDocumentoId;

    @Size(min = 10,max = 20, message = "{tamanho.invalido}")
    private String numeroDocumento;

    @NotNull(message = "{campo.nulo}")
    @Min(value = 1, message = "{id.abaixo.do.minimo}")
    private Long cargoId;

    @NotNull(message = "{campo.nulo}")
    @Min(value = 1, message = "{id.abaixo.do.minimo}")
    private Long departamentoId;

    @Min(value = 1000, message = "{salario.abaixo.do.minimo}")
    private double salario;

    @NotNull(message = "{campo.nulo}")
    private Date dataInicio;

    @NotNull(message = "{campo.nulo}")
    private boolean ativo;

    @Size(min = 8,max = 15, message = "{tamanho.invalido}")
    private String telefone;

    @Email(message = "{email.invalido}")
    private String email;
}
