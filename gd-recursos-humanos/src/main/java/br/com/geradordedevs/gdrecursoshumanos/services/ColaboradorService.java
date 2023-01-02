package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;

public interface ColaboradorService {
    Iterable<ColaboradorEntity> findAll();
    ColaboradorEntity findById(Long id );
    ColaboradorEntity save( ColaboradorEntity entity);
    ColaboradorEntity update( Long id,  ColaboradorEntity entity);
    void deleteById ( Long id);
    void populating();
}
