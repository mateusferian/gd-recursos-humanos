package br.com.geradordedevs.gdrecursoshumanos.facades;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;

import java.util.List;

public interface AtestadoFacade {
    List<AtestadoResponseDTO> findAll(String token);
    AtestadoResponseDTO findById(Long id,String token );
    AtestadoResponseDTO save(AtestadoRequestDTO request,String token);
    AtestadoResponseDTO update ( Long id,  AtestadoRequestDTO request,String token);
    void deleteById ( Long id,String token);
    void populating(String token);
}
