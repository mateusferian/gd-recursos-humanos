package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
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
    public List<DepartamentoResponseDTO> listar() {
        return departamentoService.listar();
    }

    @GetMapping("/{id}")
    public DepartamentoResponseDTO consultar(@PathVariable Long id) {
        return departamentoService.consultar(id);
    }

    @PostMapping
    public DepartamentoResponseDTO cadastrar(@RequestBody DepartamentoRequestDTO request) {
        return departamentoService.cadastrar(request);
    }

    @PutMapping("/{id}")
    public DepartamentoResponseDTO alterar(@PathVariable Long id, @RequestBody DepartamentoRequestDTO request) {
        return departamentoService.alterar(id,request);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        departamentoService.remover(id);
    }

    @GetMapping("/popular")
    public List<DepartamentoResponseDTO> popularBanco(){
        departamentoService.popular();
        return departamentoService.listar();
    }
}
