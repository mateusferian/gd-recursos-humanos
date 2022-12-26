package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facedes.UsuarioFacede;
import br.com.geradordedevs.gdrecursoshumanos.services.UsuarioService;
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
    public List<UsuarioResponseDTO> listar(){
        return usuarioFacede.listar();
    }

    @GetMapping ("/{id}")
    public UsuarioResponseDTO consultar(@PathVariable Long id){
        return  usuarioFacede.consultar(id);
    }
    
    @PostMapping
    public  UsuarioResponseDTO cadastrar(@Valid @RequestBody UsuarioRequestDTO request){
        return  usuarioFacede.cadastrar(request);
    }

    @PutMapping ("/{id}")
    public  UsuarioResponseDTO alterar(@PathVariable Long id,@Valid @RequestBody UsuarioRequestDTO request){
        return  usuarioFacede.alterar(id, request);
    }

    @DeleteMapping("/{id}")
    public  void  remover(@PathVariable Long id){
        usuarioFacede.remover(id);
    }
}
