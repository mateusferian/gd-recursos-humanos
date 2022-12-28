package br.com.geradordedevs.gdrecursoshumanos.exceptions;

import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.AtestadoEnum;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.CargoEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class AtestadoException extends RecursosHumanosException{

    public AtestadoException(AtestadoEnum error){
        super(error.getMessage());
        this.error =  error;
    }

    private  final AtestadoEnum error;
}
