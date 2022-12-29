package br.com.geradordedevs.gdrecursoshumanos.facades;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioFacade {
    List<UsuarioResponseDTO> findAll(String token);
    UsuarioResponseDTO findById(Long id ,String token);
    UsuarioResponseDTO save( UsuarioRequestDTO request);
    UsuarioResponseDTO update ( Long id, UsuarioRequestDTO request,String token);
    void  deleteById(  Long id,String token);
}
