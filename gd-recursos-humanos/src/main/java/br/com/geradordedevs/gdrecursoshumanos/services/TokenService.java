package br.com.geradordedevs.gdrecursoshumanos.services;

public interface TokenService {
    String generateToken(String email);
    void validate(String token);
}
