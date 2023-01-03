package br.com.geradordedevs.gdrecursoshumanos.services.impl;

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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class TokenServiceImpl implements TokenService {
    @Value("${jwt.secret}")
    private  String secret;

    @Value("{jwt.issuer}")
    private  String issuer;
    public DecodedJWT jwt;

    @Override
    public String generateToken(String email) {
        log.info("generating jwt token for email {}", email);

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);

            return JWT.create()
                    .withIssuer(issuer)
                    .withClaim("sub", email)
                    .withExpiresAt(new Date(Instant.now().toEpochMilli() + TimeUnit.HOURS.toMillis(1)))//1h
                    .sign(algorithm);

        } catch (JWTCreationException exception) {
            log.warn("error when trying to generate jwt token");
            throw new TokenException(TokenEnum.INVALID_TOKEN);
        }
    }

    @Override
    public void validate(String token) {
        
        if (token == null) {
            log.warn("token not sent");
            throw new TokenException(TokenEnum.MANDATORY_TOKEN);
        }

        log.info("validating the token: {}", token);
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(issuer)
                    .build();
            DecodedJWT jwt = verifier.verify(token);

        } catch (JWTVerificationException exception) {
            log.warn("token verification error: {}", token);
            throw new TokenException(TokenEnum.INVALID_TOKEN);
        }
    }
}
