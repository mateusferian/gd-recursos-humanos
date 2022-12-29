package br.com.geradordedevs.gdrecursoshumanos.facades;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AutenticacaoResponseDTO;

public interface TokenFacade {
    AutenticacaoResponseDTO autenticacao(AutenticacaoRequestDTO requestD);
}
