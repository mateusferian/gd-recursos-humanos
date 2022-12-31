package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum AtestadoEnum {

    CERTIFICATE_NOT_FOUND("CERTIFICATE_NOT_FOUND", "Atestado não encontrado", 404);

    private String code;
    private String message;
    private Integer statusCode;
}
