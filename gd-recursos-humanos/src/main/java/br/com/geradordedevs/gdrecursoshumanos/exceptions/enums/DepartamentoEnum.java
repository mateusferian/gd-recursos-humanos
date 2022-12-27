package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum DepartamentoEnum {

    DEPARTAMENTO_NAO_ENCONTRADO("DEPARTAMENTO_NAO_ENCONTRADO", "Departamento não encontrado", 404);

    private String code;
    private String message;
    private Integer statusCode;

}
