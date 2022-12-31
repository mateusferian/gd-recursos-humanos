package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum UsuarioEnum {

    INVALID_USERNAME_OR_PASSWORD("INVALID_USERNAME_OR_PASSWORD", "Usuario ou senha invalidos", 400),
    USER_NOT_FOUND("USER_NOT_FOUND","Usuario não encontrado",404);

    private String code;
    private String message;
    private Integer statusCode;
}
