package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoDocumentoRequestDTO {

    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 2,max = 6, message = "{tamanho.invalido}")
    private String nome;
}
