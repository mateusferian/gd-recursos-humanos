package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
import br.com.geradordedevs.gdrecursoshumanos.repositories.DepartamentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;
    @GetMapping
    public Iterable<DepartamentoEntity> listar() {
        return departamentoService.listar();
    }

    @GetMapping("/{id}")
    public DepartamentoEntity consultar(@PathVariable Long id) {
        return departamentoService.consultar(id);
    }

    @PostMapping
    public DepartamentoEntity cadastrar(@RequestBody DepartamentoEntity departamentoEntity) {
        return departamentoService.cadastrar(departamentoEntity);
    }

    @PutMapping("/{id}")
    public DepartamentoEntity alterar(@PathVariable Long id, @RequestBody DepartamentoEntity departamentoEntity) {
        return departamentoService.alterar(id,departamentoEntity);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        departamentoService.remover(id);
    }

    @GetMapping("/popular")
    public Iterable<DepartamentoEntity> popularBanco(){
        departamentoService.popular();
        return departamentoService.listar();
    }
}
