package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TipoDocumentoService {
    List<TipoDocumentoResponseDTO> listar();
    TipoDocumentoResponseDTO consultar(Long id );
    TipoDocumentoResponseDTO cadastrar( TipoDocumentoRequestDTO request);
    TipoDocumentoResponseDTO alterar ( Long id,  TipoDocumentoRequestDTO request);
    void  remover(  Long id);
    void popular();
}
