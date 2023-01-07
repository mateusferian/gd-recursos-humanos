package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.JwtResponseDTO;

public interface TokenService {
    String generateToken(String email);
    JwtResponseDTO validate(String token);
}
