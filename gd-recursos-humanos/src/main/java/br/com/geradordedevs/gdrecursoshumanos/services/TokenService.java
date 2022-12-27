package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.JwtResponseDTO;

public interface TokenService {
    String gerarToken(String email);
    JwtResponseDTO validar(String token);
}
