package br.com.geradordedevs.gdrecursoshumanos.facedes.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AutenticacaoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facedes.UsuarioFacede;
import br.com.geradordedevs.gdrecursoshumanos.mappers.UsuarioMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UsuarioFacedeImpl implements UsuarioFacede {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper mapper;

    @Override
    public List<UsuarioResponseDTO> listar() {
        return mapper.paraListaDto(usuarioService.listar());
    }

    @Override
    public UsuarioResponseDTO consultar(Long id) {
        return mapper.paraDto(usuarioService.consultar(id));
    }

    @Override
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO request) {
        return mapper.paraDto(usuarioService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public UsuarioResponseDTO alterar(Long id, UsuarioRequestDTO request) {
        return mapper.paraDto(usuarioService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id) {
        usuarioService.remover(id);
    }
}
