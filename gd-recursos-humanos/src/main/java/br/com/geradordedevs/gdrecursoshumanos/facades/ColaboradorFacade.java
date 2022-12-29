package br.com.geradordedevs.gdrecursoshumanos.facades;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;

import java.util.List;

public interface ColaboradorFacade {
    List<ColaboradorResponseDTO> listar(String token);
    ColaboradorResponseDTO consultar(Long id,String token );
    ColaboradorResponseDTO cadastrar( ColaboradorRequestDTO request,String token);
    ColaboradorResponseDTO alterar ( Long id,  ColaboradorRequestDTO request,String token);
    void remover ( Long id,String token);
    void popular(String token);
}
