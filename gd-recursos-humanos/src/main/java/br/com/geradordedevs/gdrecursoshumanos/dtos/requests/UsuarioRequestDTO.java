package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequestDTO {

    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 3,max = 40, message = "{tamanho.invalido}")
    private String nome;

    @NotNull(message = "{campo.nulo}")
    @Email(message = "{email.invalido}")
    private String email;

    @NotBlank(message = "{campo.em.branco}")
    @Size(min = 8,max = 20, message = "{tamanho.invalido}")
    private String senha;

    @Override
    public String toString() {
        return "UsuarioRequestDTO{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
