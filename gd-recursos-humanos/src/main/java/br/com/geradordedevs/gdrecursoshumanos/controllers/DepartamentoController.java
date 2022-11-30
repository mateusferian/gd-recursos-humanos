package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
import br.com.geradordedevs.gdrecursoshumanos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/departamentos")
public class DepartamentoController {
    @Autowired
    private DepartamentoRepository departamentoRepository;
    @GetMapping
    public Iterable<DepartamentoEntity> listar() {
        return departamentoRepository.findAll();

    }

    @GetMapping("/{id}")
    public Optional<DepartamentoEntity> consultar(@PathVariable Long id) {
        return departamentoRepository.findById(id);


    }


    @PostMapping
    public DepartamentoEntity cadastrar(@RequestBody DepartamentoEntity departamentoEntity) {
        return departamentoRepository.save(departamentoEntity);

    }

    @PutMapping("/{id}")
    public DepartamentoEntity alterar(@PathVariable Long id, @RequestBody DepartamentoEntity departamentoEntity) {
        departamentoEntity.setId(id);
        return departamentoRepository.save(departamentoEntity);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        departamentoRepository.deleteById(id);
    }

}
