package br.com.geradordedevs.gdrecursoshumanos.facedes;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;

import java.util.List;

public interface CargoFacede {
    List<CargoResponseDTO> listar(String token);
    CargoResponseDTO consultar(Long id);
    CargoResponseDTO cadastrar(CargoRequestDTO request);
    CargoResponseDTO alterar(Long id, CargoRequestDTO request);
    void remover(Long id);
    void popular();
}
