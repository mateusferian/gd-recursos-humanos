package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
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
    @GetMapping
    public Iterable<CargoEntity> listar(){
        return cargoRepository.findAll();

    }
    @GetMapping ("/{id}")
    public Optional<CargoEntity> consultar(@PathVariable Long id ){
        return cargoRepository.findById(id);


    }

    @PostMapping
    public CargoEntity cadastrar(@RequestBody CargoEntity cargoEntity){

        return cargoRepository.save(cargoEntity);

    }
    @PutMapping ("/{id}")
    //precisa arrumar essa parte//
    public CargoEntity alterar (@PathVariable Long id, @RequestBody CargoEntity cargoEntity){
        cargoEntity.setId(id);
        return cargoRepository.save(cargoEntity);
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable Long id){
        cargoRepository.deleteById(id);
    }
}
