package br.com.geradordedevs.gdrecursoshumanos.exceptions;

import antlr.Token;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.TokenEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class TokenException extends RecursosHumanosException{

    public TokenException(TokenEnum error){
        super(error.getMessage());
        this.error =  error;
    }

    private  final TokenEnum error;
}
