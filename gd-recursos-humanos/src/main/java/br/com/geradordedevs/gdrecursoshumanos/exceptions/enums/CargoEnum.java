package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CargoEnum {

    POSITION_NOT_FOUND("POSITION_NOT_FOUND", "Cargo não encontrado", 404);

    private String code;
    private String message;
    private Integer statusCode;

}
