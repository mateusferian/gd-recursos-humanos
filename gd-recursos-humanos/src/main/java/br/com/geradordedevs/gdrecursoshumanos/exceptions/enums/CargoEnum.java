package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum CargoEnum {
    CARGO_NAO_ENCONTRADO("CARGO_NAO_ENCONTRADO", "Cargo não encontrado", 404);

    private String code;
    private String message;
    private Integer statusCode;

}
