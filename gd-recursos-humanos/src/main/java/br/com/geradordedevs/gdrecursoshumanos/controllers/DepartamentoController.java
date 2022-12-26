package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.facedes.DepartamentoFacede;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
import br.com.geradordedevs.gdrecursoshumanos.repositories.DepartamentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoFacede departamentoFacede;

    @GetMapping
    public List<DepartamentoResponseDTO> listar() {
        return departamentoFacede.listar();
    }

    @GetMapping("/{id}")
    public DepartamentoResponseDTO consultar(@PathVariable Long id) {
        return departamentoFacede.consultar(id);
    }

    @PostMapping
    public DepartamentoResponseDTO cadastrar(@Valid @RequestBody DepartamentoRequestDTO request) {
        return departamentoFacede.cadastrar(request);
    }

    @PutMapping("/{id}")
    public DepartamentoResponseDTO alterar(@PathVariable Long id,@Valid @RequestBody DepartamentoRequestDTO request) {
        return departamentoFacede.alterar(id,request);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id) {
        departamentoFacede.remover(id);
    }

    @GetMapping("/popular")
    public void popularBanco(){
        departamentoFacede.popular();
    }
}
