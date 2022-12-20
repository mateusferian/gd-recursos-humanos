package br.com.geradordedevs.gdrecursoshumanos.dtos.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class AutenticacaoRequestDTO {
    private  String email;
    private  String senha;
}
