package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.facedes.CargoFacede;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoFacede cargoFacede;

    @GetMapping
    public List<CargoResponseDTO> listar(){
        return cargoFacede.listar();
    }

    @GetMapping ("/{id}")
    public CargoResponseDTO consultar(@PathVariable Long id ){
        return cargoFacede.consultar(id);
    }

    @PostMapping
    public CargoResponseDTO cadastrar(@Valid @RequestBody CargoRequestDTO request){
        return cargoFacede.cadastrar(request);
    }

    @PutMapping ("/{id}")
    public CargoResponseDTO alterar (@PathVariable Long id,@Valid @RequestBody CargoRequestDTO request){
        return cargoFacede.alterar(id, request);
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable Long id){
        cargoFacede.remover(id);
    }

    @GetMapping("/popular")
    public void popularBanco(){
        cargoFacede.popular();
    }
}
