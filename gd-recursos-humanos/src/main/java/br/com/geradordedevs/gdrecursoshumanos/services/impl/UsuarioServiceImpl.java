package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AutenticacaoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.UsuarioEntity;
import br.com.geradordedevs.gdrecursoshumanos.mappers.UsuarioMapper;
import br.com.geradordedevs.gdrecursoshumanos.repositories.UsuarioRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.UsuarioService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UsuarioServiceImpl  implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioMapper mapper;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public List<UsuarioResponseDTO> listar() {
        List<UsuarioEntity> usuarioEntities = new ArrayList<>();
        for (UsuarioEntity usuarioEntity: usuarioRepository.findAll()) {
            usuarioEntities.add(usuarioEntity);
        }
        return mapper.paraListaDto(usuarioEntities);
    }

    @Override
    public UsuarioResponseDTO consultar(Long id) {
        log.info("obtendo informacoes de usuario {}",id);
        return mapper.paraDto(usuarioRepository.findById(id).orElse(new UsuarioEntity()));
    }

    @Override
    public UsuarioResponseDTO cadastrar(UsuarioRequestDTO request) {
        log.info("cadastrando um novo usuario {}",request);
        UsuarioEntity usuario = mapper.paraEntidade(request);
        usuario.setSenha(passwordEncoder.encode(request.getSenha()));
        return mapper.paraDto(usuarioRepository.save(usuario));
    }

    @Override
    public UsuarioResponseDTO alterar(Long id, UsuarioRequestDTO request) {
        log.info("alterando usuario de id {} com novas informacoes: {}",id,request);
            UsuarioEntity usuario = mapper.paraEntidade(request);
            usuario.setId(id);
        return mapper.paraDto(usuarioRepository.save(usuario));
    }

    @Override
    public void remover(Long id) {
        log.info("removendo o usuario de id {}",id);
        usuarioRepository.deleteById(id);
    }
}
