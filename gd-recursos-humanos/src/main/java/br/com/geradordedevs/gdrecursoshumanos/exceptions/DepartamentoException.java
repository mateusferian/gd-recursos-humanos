package br.com.geradordedevs.gdrecursoshumanos.exceptions;


import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.DepartamentoEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class DepartamentoException extends RecursosHumanosException{

    public DepartamentoException(DepartamentoEnum error){
        super(error.getMessage());
        this.error =  error;
    }

    private  final DepartamentoEnum error;
}
