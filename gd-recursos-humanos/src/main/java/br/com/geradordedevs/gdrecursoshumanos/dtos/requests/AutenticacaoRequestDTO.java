package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@NoArgsConstructor
@Getter
@AllArgsConstructor
public class AutenticacaoRequestDTO {
    @NotBlank(message = "{campo.em.branco}")
    @Email(message = "{email.invalido}")
    private  String email;

    @NotBlank(message = "{campo.em.branco}")
    private  String senha;
}
