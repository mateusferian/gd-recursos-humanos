package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;

import java.util.List;

public interface CargoService {
    Iterable<CargoEntity> findAll();
    CargoEntity findById(Long id);
    CargoEntity save(CargoEntity entity);
    CargoEntity update(Long id, CargoEntity entity);
    void deleteById(Long id);
    void populating();
}
