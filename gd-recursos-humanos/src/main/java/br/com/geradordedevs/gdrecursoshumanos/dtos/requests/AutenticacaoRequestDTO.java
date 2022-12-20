package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@Getter
public class AutenticacaoRequestDTO {
    @Email(message = "{email.invalido}")
    private  String email;

    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 8,max = 20, message = "{tamanho.invalido}")
    private  String senha;
}
