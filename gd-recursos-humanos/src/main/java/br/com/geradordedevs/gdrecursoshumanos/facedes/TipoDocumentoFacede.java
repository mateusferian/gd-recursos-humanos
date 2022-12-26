package br.com.geradordedevs.gdrecursoshumanos.facedes;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;

import java.util.List;

public interface TipoDocumentoFacede {
    List<TipoDocumentoResponseDTO> listar();
    TipoDocumentoResponseDTO consultar(Long id );
    TipoDocumentoResponseDTO cadastrar( TipoDocumentoRequestDTO request);
    TipoDocumentoResponseDTO alterar ( Long id,  TipoDocumentoRequestDTO request);
    void  remover(  Long id);
    void popular();
}
