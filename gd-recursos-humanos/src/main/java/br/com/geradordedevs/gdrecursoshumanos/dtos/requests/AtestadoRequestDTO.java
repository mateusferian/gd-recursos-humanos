package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AtestadoRequestDTO {

    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 3,max = 40, message = "{tamanho.invalido}")
    private String nome;

    @PastOrPresent(message = "{data.inicio.invalida}")
    @NotNull(message = "{campo.nulo}")
    private Date data;

    @NotNull(message = "{campo.nulo}")
    @Min(value = 1, message = "{id.abaixo.do.minimo}")
    private Long colaborador;
}
