package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface AtestadoService {
    Iterable<AtestadoEntity> listar();
    AtestadoEntity consultar(@PathVariable Long id );
    AtestadoEntity cadastrar(@RequestBody AtestadoEntity atestadoEntity);
    AtestadoEntity alterar (@PathVariable long id, @RequestBody AtestadoEntity atestadoEntity);
    void remover (@PathVariable Long id);
    public void popular();
}
