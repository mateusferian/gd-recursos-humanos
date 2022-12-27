package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AtestadoEnum {
    ATESTADO_NAO_ENCONTRADO("ATESTADO_NAO_ENCONTRADO", "Atestado não encontrado", 404);

    private String code;
    private String message;
    private Integer statusCode;
}
