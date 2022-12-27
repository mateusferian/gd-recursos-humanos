package br.com.geradordedevs.gdrecursoshumanos.exceptions.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum TipoDocumentoEnum {
    TIPO_DOCUMENTO_NAO_ENCONTRADO("TIPO_DOCUMENTO_NAO_ENCONTRADO", "Tipo de documento não encontrado", 404);

    private String code;
    private String message;
    private Integer statusCode;

}
