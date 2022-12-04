package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

public interface DepartamentoService {
    Iterable<DepartamentoEntity> listar();
    DepartamentoEntity consultar(@PathVariable Long id);
    DepartamentoEntity cadastrar(@RequestBody DepartamentoEntity departamentoEntity);
    DepartamentoEntity alterar(@PathVariable Long id, @RequestBody DepartamentoEntity departamentoEntity);
    void remover(@PathVariable Long id);
     void popular();
}
