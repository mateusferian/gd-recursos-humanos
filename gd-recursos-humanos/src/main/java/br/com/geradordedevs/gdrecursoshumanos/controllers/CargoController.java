package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
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
    private CargoRepository cargoRepository;
    @Autowired
    private CargoService cargoService;
    @GetMapping
    public Iterable<CargoEntity> listar(){
        return cargoService.listar();

    }
    @GetMapping ("/{id}")
    public CargoEntity consultar(@PathVariable Long id ){
        return cargoService.consultar(id);


    }

    @PostMapping
    public CargoEntity cadastrar(@RequestBody CargoEntity cargoEntity){
        return cargoService.cadastrar(cargoEntity);

    }
    @PutMapping ("/{id}")
    //precisa arrumar essa parte//
    public CargoEntity alterar (@PathVariable Long id, @RequestBody CargoEntity cargoEntity){
        return cargoService.alterar(id, cargoEntity);
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable Long id){
            cargoService.remover(id);
    }
}
