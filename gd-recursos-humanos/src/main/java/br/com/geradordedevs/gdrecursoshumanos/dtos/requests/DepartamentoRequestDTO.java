package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartamentoRequestDTO {
    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 3,max = 30, message = "{tamanho.invalido}")
    private String nome;
}
