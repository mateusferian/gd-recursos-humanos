package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;

public interface TipoDocumentoService {
    Iterable<TipoDocumentoEntity> findAll();
    TipoDocumentoEntity findById(Long id );
    TipoDocumentoEntity save( TipoDocumentoEntity entity);
    TipoDocumentoEntity update ( Long id,  TipoDocumentoEntity entity);
    void  deleteById(  Long id);
    void populating();
}
