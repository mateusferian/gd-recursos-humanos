package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface ColaboradorService {
    Iterable<ColaboradorEntity> listar();
    ColaboradorEntity consultar(@PathVariable Long id );
    ColaboradorEntity cadastrar(@RequestBody ColaboradorEntity colaboradorEntity);
    ColaboradorEntity alterar (@PathVariable Long id, @RequestBody ColaboradorEntity colaboradorEntity);
    void remover (@PathVariable Long id);
     void popular();
}
