package br.com.geradordedevs.gdrecursoshumanos.facades;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;

import java.util.List;

public interface CargoFacade {
    List<CargoResponseDTO> findAll(String token);
    CargoResponseDTO findById(Long id,String token);
    CargoResponseDTO save(CargoRequestDTO request,String token);
    CargoResponseDTO update(Long id, CargoRequestDTO request,String token);
    void deleteById(Long id,String token);
    void popular(String token);
}
