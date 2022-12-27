package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum UsuarioEnum {
    USUARIO_OU_SENHA_INVALIDOS("USUARIO_OU_SENHA_INVALIDOS", "Usuario ou senha invalidos", 404),
    USUARIO_NAO_ENCONTRADO("USUARIO_NAO_ENCONTRADO","Usuario não encontrado",404);

    private String code;
    private String message;
    private Integer statusCode;
}
