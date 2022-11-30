package br.com.geradordedevs.gdrecursoshumanos.controllers;


import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.ColaboradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/colaboradores")
public class ColaboradorController {
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @GetMapping
    public Iterable<ColaboradorEntity> listar(){
        return colaboradorRepository.findAll();

    }
    @GetMapping ("/{id}")
public Optional<ColaboradorEntity> consultar(@PathVariable Long id ){
        return colaboradorRepository.findById(id);
}


 @PostMapping
    public ColaboradorEntity cadastrar(@RequestBody ColaboradorEntity colaboradorEntity){
     return colaboradorRepository.save(colaboradorEntity);
    }

    @PutMapping ("/{id}")
    public ColaboradorEntity alterar (@PathVariable Long id, @RequestBody ColaboradorEntity colaboradorEntity){
        colaboradorEntity.setId(id);
        return colaboradorRepository.save(colaboradorEntity);
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable Long id){
        colaboradorRepository.deleteById(id);
    }
}

