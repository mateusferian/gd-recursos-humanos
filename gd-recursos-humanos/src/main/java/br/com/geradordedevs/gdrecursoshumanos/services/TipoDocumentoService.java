package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TipoDocumentoService {
    Iterable<TipoDocumentoEntity> listar();
    TipoDocumentoEntity consultar(Long id );
    TipoDocumentoEntity cadastrar( TipoDocumentoEntity entity);
    TipoDocumentoEntity alterar ( Long id,  TipoDocumentoEntity entity);
    void  remover(  Long id);
    void popular();
}
