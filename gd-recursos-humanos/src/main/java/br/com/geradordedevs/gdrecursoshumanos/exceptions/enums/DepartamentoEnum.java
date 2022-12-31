package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum DepartamentoEnum {

    DEPARTMENT_NOT_FOUND("DEPARTMENT_NOT_FOUND", "Departamento não encontrado", 404);

    private String code;
    private String message;
    private Integer statusCode;

}
