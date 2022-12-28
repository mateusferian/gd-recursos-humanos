package br.com.geradordedevs.gdrecursoshumanos.exceptions;

import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.CargoEnum;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.TipoDocumentoEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class TipoDocumentoException extends RecursosHumanosException{

    public TipoDocumentoException(TipoDocumentoEnum error){
        super(error.getMessage());
        this.error =  error;
    }

    private  final TipoDocumentoEnum error;
}
