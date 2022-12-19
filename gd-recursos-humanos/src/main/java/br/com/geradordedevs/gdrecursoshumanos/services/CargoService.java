package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;

import java.util.List;

public interface CargoService {
    List<CargoResponseDTO> listar();
    CargoResponseDTO consultar(Long id);
    CargoResponseDTO cadastrar(CargoRequestDTO request);
    CargoResponseDTO alterar(Long id, CargoRequestDTO request );
    void remover(Long id);
    void popular();
}
