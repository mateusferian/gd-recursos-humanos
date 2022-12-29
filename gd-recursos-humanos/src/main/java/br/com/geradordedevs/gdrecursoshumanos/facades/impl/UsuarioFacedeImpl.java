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
    public List<UsuarioResponseDTO> findAll(String token) {
        tokenService.validate(token);
        return mapper.toDtoList(usuarioService.findAll());
    }

    @Override
    public UsuarioResponseDTO findById(Long id,String token) {
        tokenService.validate(token);
        return mapper.toDto(usuarioService.findById(id));
    }

    @Override
    public UsuarioResponseDTO save(UsuarioRequestDTO request) {
        return mapper.toDto(usuarioService.save(mapper.toEntity(request)));
    }

    @Override
    public UsuarioResponseDTO updateById(Long id, UsuarioRequestDTO request,String token) {
        tokenService.validate(token);
        return mapper.toDto(usuarioService.updateById(id,mapper.toEntity(request)));
    }

    @Override
    public void deleteById(Long id,String token) {
        tokenService.validate(token);
        usuarioService.deleteById(id);
    }
}
