package br.com.geradordedevs.gdrecursoshumanos.facedes;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;

import java.util.List;

public interface TipoDocumentoFacede {
    List<TipoDocumentoResponseDTO> listar(String token);
    TipoDocumentoResponseDTO consultar(Long id,String token);
    TipoDocumentoResponseDTO cadastrar( TipoDocumentoRequestDTO request,String token);
    TipoDocumentoResponseDTO alterar ( Long id,  TipoDocumentoRequestDTO request,String token);
    void  remover(  Long id,String token);
    void popular(String token);
}
