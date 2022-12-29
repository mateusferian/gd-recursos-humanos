package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface TipoDocumentoService {
    Iterable<TipoDocumentoEntity> findAll();
    TipoDocumentoEntity findById(Long id );
    TipoDocumentoEntity save( TipoDocumentoEntity entity);
    TipoDocumentoEntity updateById ( Long id,  TipoDocumentoEntity entity);
    void  deleteById(  Long id);
    void popular();
}
