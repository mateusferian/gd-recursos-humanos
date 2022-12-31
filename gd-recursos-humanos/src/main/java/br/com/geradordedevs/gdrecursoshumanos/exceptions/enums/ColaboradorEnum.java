package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ColaboradorEnum {

    EMPLOYEE_NOT_FOUND("EMPLOYEE_NOT_FOUND", "Colaborador não encontrado", 404);

    private String code;
    private String message;
    private Integer statusCode;

}
