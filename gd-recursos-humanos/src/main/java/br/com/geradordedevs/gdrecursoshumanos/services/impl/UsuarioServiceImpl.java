package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AutenticacaoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.UsuarioEntity;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.UsuarioException;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.UsuarioEnum;
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
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Iterable<UsuarioEntity> findAll() {
        log.info("listing users");
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity findById(Long id) {
        log.info("getting user information {}",id);
        return usuarioRepository.findById(id).orElseThrow(() -> new UsuarioException(UsuarioEnum.USER_NOT_FOUND));
    }

    @Override
    public UsuarioEntity save(UsuarioEntity entity) {
        log.info("registering a new user {}",entity);
        entity.setSenha(passwordEncoder.encode(entity.getSenha()));
        return usuarioRepository.save(entity);
    }

    @Override
    public UsuarioEntity update(Long id, UsuarioEntity entity) {
        log.info("changing user id {} with new information: {}",id,entity);
        findById(id);
        entity.setId(id);
        entity.setSenha(passwordEncoder.encode(entity.getSenha()));
        return usuarioRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        log.info("removing user from id {}",id);
        findById(id);
        usuarioRepository.deleteById(id);
    }

    @Override
    public void validateUserPassword(AutenticacaoRequestDTO request) {
        log.info("validating email username and password: {}",request.getEmail());
        UsuarioEntity usuarioEntity = usuarioRepository.findByEmail(request.getEmail());
        if (usuarioEntity == null ||
        !passwordEncoder.matches(request.getSenha(),usuarioEntity.getSenha())){
            log.warn("email username or password {} is invalid",request.getEmail());
            throw  new UsuarioException(UsuarioEnum.INVALID_USERNAME_OR_PASSWORD);
        }
    }
}
