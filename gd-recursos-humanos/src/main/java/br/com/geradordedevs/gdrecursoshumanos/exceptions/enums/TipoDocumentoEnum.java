package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoDocumentoEnum {

    DOCUMENT_TYPE_NOT_FOUND("DOCUMENT_TYPE_NOT_FOUND", "Tipo de documento não encontrado", 404);

    private String code;
    private String message;
    private Integer statusCode;

}
