package br.com.geradordedevs.gdrecursoshumanos.facades;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;

import java.util.List;

public interface ColaboradorFacade {
    List<ColaboradorResponseDTO> findAll(String token);
    ColaboradorResponseDTO findById(Long id,String token );
    ColaboradorResponseDTO save( ColaboradorRequestDTO request,String token);
    ColaboradorResponseDTO updateById ( Long id,  ColaboradorRequestDTO request,String token);
    void deleteById ( Long id,String token);
    void popular(String token);
}
