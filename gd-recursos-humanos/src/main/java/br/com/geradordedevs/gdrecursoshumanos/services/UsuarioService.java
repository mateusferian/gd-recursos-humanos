package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AutenticacaoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.UsuarioEntity;

import java.util.List;

public interface UsuarioService {
    Iterable<UsuarioEntity> findAll();
    UsuarioEntity findById(Long id );
    UsuarioEntity save( UsuarioEntity entity);
    UsuarioEntity updateById ( Long id, UsuarioEntity entity);
    void deleteById(  Long id);
    void validateUserPassword(AutenticacaoRequestDTO request);
}
