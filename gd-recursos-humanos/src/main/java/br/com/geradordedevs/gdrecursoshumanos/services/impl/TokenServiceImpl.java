package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.JwtResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.TokenException;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.TokenEnum;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService {

    private final String JWT_SECRET = "v4SA91O=WuM5i)ap3ErJ";

    private final String JWT_ISSUER = "gd-recursos-humanos";

    @Override
    public String gerarToken(String email) {
        log.info("gerando token JWT para o email {}", email);

        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);

            return JWT.create()
                    .withIssuer(JWT_ISSUER)
                    .withClaim("sub", email)
                    .withExpiresAt(new Date(Instant.now().toEpochMilli() + TimeUnit.HOURS.toMillis(1)))//1h
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            log.warn("erro ao tentar gerar o token JWT");
            throw new TokenException(TokenEnum.TOKEN_INVALIDO);
        }
    }

    @Override
    public JwtResponseDTO validar(String token) {
        
        if (token == null) {
            log.warn("token não enviado");
            throw new TokenException(TokenEnum.TOKEN_OBRIGATORIO);
        }

        log.info("validando o token: {}", token);
        try {
            Algorithm algorithm = Algorithm.HMAC256(JWT_SECRET);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(JWT_ISSUER)
                    .build();
            DecodedJWT jwt = verifier.verify(token);

            String email = jwt.getClaim("sub").asString();
            Date dataExpiracao = jwt.getExpiresAt();

            validaExpiracaoToken(token, dataExpiracao);
            return new JwtResponseDTO(email, dataExpiracao);

        } catch (JWTVerificationException exception) {
            log.warn("erro na verificação do token: {}", token);
            throw new TokenException(TokenEnum.TOKEN_INVALIDO);
        }
    }

    private void validaExpiracaoToken(String token, Date expiresAt) {
        log.info("verificando expiracao do token {}", token);
        if (expiresAt.before(new Date())) {
            log.warn("O token {} esta expirado", token);
            throw new TokenException(TokenEnum.TOKEN_EXPIRADO);
        }
    }
}
