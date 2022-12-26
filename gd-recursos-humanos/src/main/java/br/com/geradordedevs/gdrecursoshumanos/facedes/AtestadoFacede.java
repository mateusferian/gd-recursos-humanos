package br.com.geradordedevs.gdrecursoshumanos.facedes;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;

import java.util.List;

public interface AtestadoFacede {
    List<AtestadoResponseDTO> listar();
    AtestadoResponseDTO consultar(Long id );
    AtestadoResponseDTO cadastrar(AtestadoRequestDTO request);
    AtestadoResponseDTO alterar ( Long id,  AtestadoRequestDTO request);
    void remover ( Long id);
    void popular();
}
