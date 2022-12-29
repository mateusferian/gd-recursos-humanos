package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.UsuarioFacade;
import br.com.geradordedevs.gdrecursoshumanos.mappers.UsuarioMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import br.com.geradordedevs.gdrecursoshumanos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class UsuarioFacedeImpl implements UsuarioFacade {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioMapper mapper;

    @Autowired
    private TokenService tokenService;

    @Override
    public List<UsuarioResponseDTO> listar(String token) {
        tokenService.validar(token);
        return mapper.paraListaDto(usuarioService.listar());
    }

    @Override
    public UsuarioResponseDTO consultar(Long id,String token) {
        tokenService.validar(token);
        return mapper.paraDto(usuarioService.consultar(id));
    }

    @Override
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO request) {
        return mapper.paraDto(usuarioService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public UsuarioResponseDTO alterar(Long id, UsuarioRequestDTO request,String token) {
        tokenService.validar(token);
        return mapper.paraDto(usuarioService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id,String token) {
        tokenService.validar(token);
        usuarioService.remover(id);
    }
}
