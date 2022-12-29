package br.com.geradordedevs.gdrecursoshumanos.facades;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;

import java.util.List;

public interface TipoDocumentoFacade {
    List<TipoDocumentoResponseDTO> findAll(String token);
    TipoDocumentoResponseDTO findById(Long id,String token);
    TipoDocumentoResponseDTO save( TipoDocumentoRequestDTO request,String token);
    TipoDocumentoResponseDTO updateById ( Long id,  TipoDocumentoRequestDTO request,String token);
    void  deleteById(  Long id,String token);
    void popular(String token);
}
