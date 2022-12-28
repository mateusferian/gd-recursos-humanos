package br.com.geradordedevs.gdrecursoshumanos.facedes;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AutenticacaoResponseDTO;

public interface TokenFacede {
    AutenticacaoResponseDTO autenticacao(AutenticacaoRequestDTO requestD);
}
