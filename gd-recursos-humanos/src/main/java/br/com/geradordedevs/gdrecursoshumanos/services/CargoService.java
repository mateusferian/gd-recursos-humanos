package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;

public interface CargoService {
    Iterable<CargoEntity> listar();

    CargoEntity consultar(Long id);
    CargoEntity cadastrar(CargoEntity cargoEntity);
    CargoEntity alterar(Long id, CargoEntity cargoEntity );
    void remover(Long id);
}
