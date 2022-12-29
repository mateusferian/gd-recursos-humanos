package br.com.geradordedevs.gdrecursoshumanos.facades;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;

import java.util.List;

public interface CargoFacade {
    List<CargoResponseDTO> listar(String token);
    CargoResponseDTO consultar(Long id,String token);
    CargoResponseDTO cadastrar(CargoRequestDTO request,String token);
    CargoResponseDTO alterar(Long id, CargoRequestDTO request,String token);
    void remover(Long id,String token);
    void popular(String token);
}
