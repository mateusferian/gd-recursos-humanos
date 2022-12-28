package br.com.geradordedevs.gdrecursoshumanos.controllers;


import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.facedes.ColaboradorFacede;
import br.com.geradordedevs.gdrecursoshumanos.repositories.ColaboradorRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import br.com.geradordedevs.gdrecursoshumanos.services.ColaboradorService;
import br.com.geradordedevs.gdrecursoshumanos.services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorFacede colaboradorFacede;

    @GetMapping
    public List<ColaboradorResponseDTO> listar(@RequestHeader(required = false,value = "token")String token){
        return colaboradorFacede.listar(token);
    }

    @GetMapping ("/{id}")
    public ColaboradorResponseDTO consultar(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token ){
        return colaboradorFacede.consultar(id,token);
    }

    @PostMapping
    public ColaboradorResponseDTO cadastrar(@Valid @RequestBody ColaboradorRequestDTO request, @RequestHeader(required = false,value = "token")String token){
        return colaboradorFacede.cadastrar(request,token);
    }

    @PutMapping ("/{id}")
    public ColaboradorResponseDTO alterar (@PathVariable Long id,@Valid @RequestBody ColaboradorRequestDTO request,@RequestHeader(required = false,value = "token")String token){
        return  colaboradorFacede.alterar(id, request,token);
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable Long id,@RequestHeader(required = false,value = "token")String token){
        colaboradorFacede.remover(id,token);
    }

    @GetMapping("/popular")
    public void popularBanco(@RequestHeader(required = false,value = "token")String token){
        colaboradorFacede.popular(token);
    }
}

