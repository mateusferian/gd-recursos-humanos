package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ColaboradorRequestDTO {

    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 3,max = 40, message = "{tamanho.invalido}")
    private String nome;

    @Min(value = 18, message = "{idade.abaixo.do.minimo}")
    @Max(value = 70, message = "{idade.acima.do.maximo}")
    private int idade;

    @NotNull(message = "{campo.nulo}")
    private Date dataDeNascimento;

    @NotNull(message = "{campo.nulo}")
    @Min(value = 1, message = "{id.abaixo.do.minimo}")
    @Max(value = 70, message = "{id.acima.do.maximo}")
    private Long tipoDocumento;

    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 10,max = 20, message = "{tamanho.invalido}")
    private String numeroDocumento;

    @NotNull(message = "{campo.nulo}")
    @Min(value = 1, message = "{id.abaixo.do.minimo}")
    @Max(value = 70, message = "{id.acima.do.maximo}")
    private Long cargo;

    @NotNull(message = "{campo.nulo}")
    @Min(value = 1, message = "{id.abaixo.do.minimo}")
    @Max(value = 70, message = "{id.acima.do.maximo}")
    private Long departamento;

    @Min(value = 1000, message = "{salario.abaixo.do.minimo}")
    @Max(value = 3000, message = "{salario.acima.do.maximo}")
    private double salario;


    @NotNull(message = "{campo.nulo}")
    private Date dataInicio;
    
    private boolean ativo;

    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 8,max = 15, message = "{tamanho.invalido}")
    private String telefone;

    @NotNull(message = "{campo.nulo}")
    @Email(message = "{email.invalido}")
    private String email;
}
