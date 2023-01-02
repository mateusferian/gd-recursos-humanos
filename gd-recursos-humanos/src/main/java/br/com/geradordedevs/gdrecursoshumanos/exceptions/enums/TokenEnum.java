package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TokenEnum {

    INVALID_TOKEN("INVALID_TOKEN", "Token inválido", 401),
    MANDATORY_TOKEN("MANDATORY_TOKEN", "Token obrigatório", 401);

    private String code;
    private String message;
    private Integer statusCode;
}
