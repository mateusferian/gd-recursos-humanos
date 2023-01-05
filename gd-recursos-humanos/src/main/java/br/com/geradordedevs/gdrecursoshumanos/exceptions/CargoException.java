package br.com.geradordedevs.gdrecursoshumanos.exceptions;

import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.CargoEnum;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Builder
@EqualsAndHashCode(callSuper = false)
public class CargoException extends RecursosHumanosException{

    public CargoException(CargoEnum error){
        super(error.getMessage());
        this.error =  error;
    }

    private  final CargoEnum error;
}
