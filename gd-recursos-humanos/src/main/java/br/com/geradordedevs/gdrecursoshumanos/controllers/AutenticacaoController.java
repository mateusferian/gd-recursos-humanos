package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AutenticacaoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AutenticacaoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/autenticacoes")
public class AutenticacaoController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping
    public AutenticacaoResponseDTO autenticacao(@RequestBody AutenticacaoRequestDTO request){
      return usuarioService.autenticacao(request);
    }
}
