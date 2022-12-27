package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TokenEnum {
    TOKEN_INVALIDO("TOKEN_INVALIDO", "Token inválido", 401),
    TOKEN_OBRIGATORIO("TOKEN_OBRIGATORIO", "Token obrigatório", 401);

    private String code;
    private String message;
    private Integer statusCode;
}
