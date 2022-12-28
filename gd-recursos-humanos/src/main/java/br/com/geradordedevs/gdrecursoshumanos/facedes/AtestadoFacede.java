package br.com.geradordedevs.gdrecursoshumanos.facedes;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;

import java.util.List;

public interface AtestadoFacede {
    List<AtestadoResponseDTO> listar(String token);
    AtestadoResponseDTO consultar(Long id,String token );
    AtestadoResponseDTO cadastrar(AtestadoRequestDTO request,String token);
    AtestadoResponseDTO alterar ( Long id,  AtestadoRequestDTO request,String token);
    void remover ( Long id,String token);
    void popular(String token);
}
