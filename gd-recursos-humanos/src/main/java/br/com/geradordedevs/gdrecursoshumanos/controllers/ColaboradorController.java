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
    public List<ColaboradorResponseDTO> listar(){
        return colaboradorFacede.listar();
    }

    @GetMapping ("/{id}")
    public ColaboradorResponseDTO consultar(@PathVariable Long id ){
        return colaboradorFacede.consultar(id);
    }

    @PostMapping
    public ColaboradorResponseDTO cadastrar(@Valid @RequestBody ColaboradorRequestDTO request){
        return colaboradorFacede.cadastrar(request);
    }

    @PutMapping ("/{id}")
    public ColaboradorResponseDTO alterar (@PathVariable Long id,@Valid @RequestBody ColaboradorRequestDTO request){
        return  colaboradorFacede.alterar(id, request);
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable Long id){
        colaboradorFacede.remover(id);
    }

    @GetMapping("/popular")
    public void popularBanco(){
        colaboradorFacede.popular();
    }
}

