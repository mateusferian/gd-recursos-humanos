package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoRequestDTO {
    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 3,max = 20, message = "{tamanho.invalido}")
    private String nome;
}
