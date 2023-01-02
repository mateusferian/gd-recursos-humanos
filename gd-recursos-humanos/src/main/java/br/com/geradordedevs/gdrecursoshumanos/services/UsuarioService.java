package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.UsuarioEntity;

public interface UsuarioService {
    Iterable<UsuarioEntity> findAll();
    UsuarioEntity findById(Long id );
    UsuarioEntity save( UsuarioEntity entity);
    UsuarioEntity update( Long id, UsuarioEntity entity);
    void deleteById(  Long id);
    void validateUserPassword(AutenticacaoRequestDTO request);
}
