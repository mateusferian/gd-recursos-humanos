package br.com.geradordedevs.gdrecursoshumanos.facedes;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;

import java.util.List;

public interface ColaboradorFacede {
    List<ColaboradorResponseDTO> listar();
    ColaboradorResponseDTO consultar(Long id );
    ColaboradorResponseDTO cadastrar( ColaboradorRequestDTO request);
    ColaboradorResponseDTO alterar ( Long id,  ColaboradorRequestDTO request);
    void remover ( Long id);
    void popular();
}
