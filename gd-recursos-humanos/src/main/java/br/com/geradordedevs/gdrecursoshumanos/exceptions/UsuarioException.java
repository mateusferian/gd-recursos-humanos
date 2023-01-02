package br.com.geradordedevs.gdrecursoshumanos.exceptions;

import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.UsuarioEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class UsuarioException extends RecursosHumanosException{

    public UsuarioException(UsuarioEnum error){
        super(error.getMessage());
        this.error =  error;
    }

    private  final UsuarioEnum error;
}
