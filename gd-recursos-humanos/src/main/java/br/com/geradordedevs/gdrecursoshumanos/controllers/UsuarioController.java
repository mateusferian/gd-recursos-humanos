package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.UsuarioFacede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioFacede usuarioFacede;

    @GetMapping
    public List<UsuarioResponseDTO> listar(@RequestHeader(required = false,value = "token")String token){
        return usuarioFacede.listar(token);
    }

    @GetMapping ("/{id}")
    public UsuarioResponseDTO consultar(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token){
        return  usuarioFacede.consultar(id,token);
    }
    
    @PostMapping
    public  UsuarioResponseDTO cadastrar(@Valid @RequestBody UsuarioRequestDTO request){
        return  usuarioFacede.cadastrar(request);
    }

    @PutMapping ("/{id}")
    public  UsuarioResponseDTO alterar(@PathVariable Long id,@Valid @RequestBody UsuarioRequestDTO request,@RequestHeader(required = false,value = "token")String token){
        return  usuarioFacede.alterar(id, request,token);
    }

    @DeleteMapping("/{id}")
    public  void  remover(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token){
        usuarioFacede.remover(id,token);
    }
}
