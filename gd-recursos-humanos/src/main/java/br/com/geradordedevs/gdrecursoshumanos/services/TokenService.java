package br.com.geradordedevs.gdrecursoshumanos.services;

public interface TokenService {
    String gerarToken(String email);
    void validar(String token);
}
