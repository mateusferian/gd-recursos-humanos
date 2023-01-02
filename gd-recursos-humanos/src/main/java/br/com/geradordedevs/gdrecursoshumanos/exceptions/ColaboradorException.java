package br.com.geradordedevs.gdrecursoshumanos.exceptions;

import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.ColaboradorEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class ColaboradorException extends RecursosHumanosException{

    public ColaboradorException(ColaboradorEnum error){
        super(error.getMessage());
        this.error =  error;
    }

    private  final ColaboradorEnum error;
}
