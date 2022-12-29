package br.com.geradordedevs.gdrecursoshumanos.facades;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioFacade {
    List<UsuarioResponseDTO> listar(String token);
    UsuarioResponseDTO consultar(Long id ,String token);
    UsuarioResponseDTO cadastrar( UsuarioRequestDTO request);
    UsuarioResponseDTO alterar ( Long id, UsuarioRequestDTO request,String token);
    void  remover(  Long id,String token);
}
