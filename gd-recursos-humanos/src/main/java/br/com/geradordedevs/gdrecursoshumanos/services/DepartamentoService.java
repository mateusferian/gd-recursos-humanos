package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;

public interface DepartamentoService {
    Iterable<DepartamentoEntity> findAll();
    DepartamentoEntity findById(Long id);
    DepartamentoEntity save(DepartamentoEntity entity);
    DepartamentoEntity update(Long id, DepartamentoEntity entity);
    void deleteById( Long id);
    void populating();
}
