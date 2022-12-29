package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.UsuarioFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioFacade usuarioFacede;

    @GetMapping
    public List<UsuarioResponseDTO> findAll(@RequestHeader(required = false,value = "token")String token){
        return usuarioFacede.findAll(token);
    }

    @GetMapping ("/{id}")
    public UsuarioResponseDTO findById(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token){
        return  usuarioFacede.findById(id,token);
    }
    
    @PostMapping
    public  UsuarioResponseDTO save(@Valid @RequestBody UsuarioRequestDTO request){
        return  usuarioFacede.save(request);
    }

    @PutMapping ("/{id}")
    public  UsuarioResponseDTO updateById(@PathVariable Long id,@Valid @RequestBody UsuarioRequestDTO request,@RequestHeader(required = false,value = "token")String token){
        return  usuarioFacede.updateById(id, request,token);
    }

    @DeleteMapping("/{id}")
    public  void  deleteById(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token){
        usuarioFacede.deleteById(id,token);
    }
}
