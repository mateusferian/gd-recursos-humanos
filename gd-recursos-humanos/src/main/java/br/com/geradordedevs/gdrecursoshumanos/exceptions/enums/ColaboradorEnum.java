package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ColaboradorEnum {
    COLABORADOR_NAO_ENCONTRADO("COLABORADOR_NAO_ENCONTRADO", "Colaborador não encontrado", 404);

    private String code;
    private String message;
    private Integer statusCode;

}
