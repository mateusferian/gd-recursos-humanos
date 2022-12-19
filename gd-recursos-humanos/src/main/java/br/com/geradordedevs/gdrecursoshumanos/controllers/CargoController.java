package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @GetMapping
    public List<CargoResponseDTO> listar(){
        return cargoService.listar();
    }

    @GetMapping ("/{id}")
    public CargoResponseDTO consultar(@PathVariable Long id ){
        return cargoService.consultar(id);
    }

    @PostMapping
    public CargoResponseDTO cadastrar(@RequestBody CargoRequestDTO request){
        return cargoService.cadastrar(request);
    }

    @PutMapping ("/{id}")
    public CargoResponseDTO alterar (@PathVariable Long id, @RequestBody CargoRequestDTO request){
        return cargoService.alterar(id, request);
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable Long id){
            cargoService.remover(id);
    }

    @GetMapping("/popular")
    public List<CargoResponseDTO> popularBanco(){
        cargoService.popular();
        return cargoService.listar();
    }
}
