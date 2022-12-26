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
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Iterable<UsuarioEntity> listar() {
        log.info("listando usuarios");
        return usuarioRepository.findAll();
    }

    @Override
    public UsuarioEntity consultar(Long id) {
        log.info("obtendo informacoes de usuario {}",id);
        return usuarioRepository.findById(id).orElse(new UsuarioEntity());
    }

    @Override
    public UsuarioEntity cadastrar(UsuarioEntity entity) {
        log.info("cadastrando um novo usuario {}",entity);
        entity.setSenha(passwordEncoder.encode(entity.getSenha()));
        return usuarioRepository.save(entity);
    }

    @Override
    public UsuarioEntity alterar(Long id, UsuarioEntity entity) {
        log.info("alterando usuario de id {} com novas informacoes: {}",id,entity);
        entity.setId(id);
        entity.setSenha(passwordEncoder.encode(entity.getSenha()));
        return usuarioRepository.save(entity);
    }

    @Override
    public void remover(Long id) {
        log.info("removendo o usuario de id {}",id);
        usuarioRepository.deleteById(id);
    }

    @Override
    public AutenticacaoResponseDTO autenticacao(AutenticacaoRequestDTO autenticacaoRequestDTO) {

        if (passwordEncoder.matches(autenticacaoRequestDTO.getSenha(), usuarioRepository.findByEmail(autenticacaoRequestDTO.getEmail()).getSenha())) {
            return new AutenticacaoResponseDTO(gerarTokenJWT(autenticacaoRequestDTO.getEmail()));
        } else {
            return new AutenticacaoResponseDTO();
        }
    }

    private String gerarTokenJWT(String email) {
        log.info("gerando token JWT para o email {}", email);
        try {
            Algorithm algorithm = Algorithm.HMAC256("v4SA91O=WuM5i)ap3ErJ");
            return JWT.create()
                    .withIssuer("gd-recursos-humanos")
                    .withClaim("sub", email)
                    .withExpiresAt(new Date(Instant.now().toEpochMilli() + TimeUnit.HOURS.toMillis(1)))
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            log.warn("erro ao tentar gerar o toker JWT");
            return null;
        }
    }
}
