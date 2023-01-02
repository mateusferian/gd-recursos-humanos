package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;

public interface AtestadoService {
    Iterable<AtestadoEntity> findAll();
    AtestadoEntity findById(Long id );
    AtestadoEntity save(AtestadoEntity entity);
    AtestadoEntity update ( long id,  AtestadoEntity entity);
    void deleteById ( Long id);
    void populating();
}
