package br.com.geradordedevs.gdrecursoshumanos.controllers;


import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.ColaboradorRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import br.com.geradordedevs.gdrecursoshumanos.services.ColaboradorService;
import br.com.geradordedevs.gdrecursoshumanos.services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorService colaboradorService;

    @GetMapping
    public List<ColaboradorResponseDTO> listar(){
        return colaboradorService.listar();
    }

    @GetMapping ("/{id}")
public ColaboradorResponseDTO consultar(@PathVariable Long id ){
        return colaboradorService.consultar(id);
    }

 @PostMapping
    public ColaboradorResponseDTO cadastrar(@RequestBody ColaboradorRequestDTO request){
        return colaboradorService.cadastrar(request);
    }

    @PutMapping ("/{id}")
    public ColaboradorResponseDTO alterar (@PathVariable Long id, @RequestBody ColaboradorRequestDTO request){
        return  colaboradorService.alterar(id, request);
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable Long id){
        colaboradorService.remover(id);
    }

    @GetMapping("/popular")
    public List<ColaboradorResponseDTO> popularBanco(){
        colaboradorService.popular();
        return colaboradorService.listar();
    }
}

