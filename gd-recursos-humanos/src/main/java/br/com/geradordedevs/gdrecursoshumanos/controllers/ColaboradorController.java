package br.com.geradordedevs.gdrecursoshumanos.controllers;


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
    public Iterable<ColaboradorEntity> listar(){
        return colaboradorService.listar();
    }

    @GetMapping ("/{id}")
public ColaboradorEntity consultar(@PathVariable Long id ){
        return colaboradorService.consultar(id);
    }

 @PostMapping
    public ColaboradorEntity cadastrar(@RequestBody ColaboradorEntity colaboradorEntity){
        return colaboradorService.cadastrar(colaboradorEntity);
    }

    @PutMapping ("/{id}")
    public ColaboradorEntity alterar (@PathVariable Long id, @RequestBody ColaboradorEntity colaboradorEntity){
        return  colaboradorService.alterar(id, colaboradorEntity);
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable Long id){
        colaboradorService.remover(id);
    }

    @GetMapping("/popular")
    public Iterable<ColaboradorEntity> popularBanco(){
        colaboradorService.popular();
        return colaboradorService.listar();
    }
}

