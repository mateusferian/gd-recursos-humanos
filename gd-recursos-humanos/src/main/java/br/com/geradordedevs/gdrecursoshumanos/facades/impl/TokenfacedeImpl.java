package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AutenticacaoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.TokenFacede;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import br.com.geradordedevs.gdrecursoshumanos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TokenfacedeImpl implements TokenFacede {
    
    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private TokenService tokenService;

    @Override
    public AutenticacaoResponseDTO autenticacao(AutenticacaoRequestDTO request) {
        usuarioService.validarUsuarioSenha(request);
        return new AutenticacaoResponseDTO(tokenService.gerarToken(request.getEmail()));
    }
}
