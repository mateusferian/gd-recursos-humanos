package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface TipoDocumentoService {
    Iterable<TipoDocumentoEntity> listar();
    TipoDocumentoEntity consultar(@PathVariable Long id );
    TipoDocumentoEntity cadastrar(@RequestBody TipoDocumentoEntity tipoDocumentoEntity);

    TipoDocumentoEntity alterar (@PathVariable Long id, @RequestBody TipoDocumentoEntity tipoDocumentoEntity);
    void  remover(@PathVariable  Long id);
     void popular();
}
