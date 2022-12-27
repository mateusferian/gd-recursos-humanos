package br.com.geradordedevs.gdrecursoshumanos.facedes;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AutenticacaoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;

import java.util.List;

public interface UsuarioFacede {
    List<UsuarioResponseDTO> listar();
    UsuarioResponseDTO consultar(Long id );
    UsuarioResponseDTO cadastrar( UsuarioRequestDTO request);
    UsuarioResponseDTO alterar ( Long id, UsuarioRequestDTO request);
    void  remover(  Long id);
}
