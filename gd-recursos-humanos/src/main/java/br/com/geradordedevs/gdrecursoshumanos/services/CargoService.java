package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;

import java.util.List;

public interface CargoService {
    Iterable<CargoEntity> listar();
    CargoEntity consultar(Long id);
    CargoEntity cadastrar(CargoEntity entity);
    CargoEntity alterar(Long id, CargoEntity entity);
    void remover(Long id);
    void popular();
}
