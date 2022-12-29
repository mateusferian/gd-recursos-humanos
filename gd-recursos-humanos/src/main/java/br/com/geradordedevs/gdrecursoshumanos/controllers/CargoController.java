package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.CargoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {

    @Autowired
    private CargoFacade cargoFacede;

    @GetMapping
    public List<CargoResponseDTO> findAll(@RequestHeader(required = false, value = "token") String token){
        return cargoFacede.findAll(token);
    }

    @GetMapping ("/{id}")
    public CargoResponseDTO findById(@PathVariable Long id, @RequestHeader(required = false, value = "token") String token){
        return cargoFacede.findById(id,token);
    }

    @PostMapping
    public CargoResponseDTO save(@Valid @RequestBody CargoRequestDTO request,@RequestHeader(required = false, value = "token") String token){
        return cargoFacede.save(request,token);
    }

    @PutMapping ("/{id}")
    public CargoResponseDTO update (@PathVariable Long id,@Valid @RequestBody CargoRequestDTO request,@RequestHeader(required = false, value = "token") String token){
        return cargoFacede.update(id, request,token);
    }

    @DeleteMapping ("/{id}")
    public void deleteById (@PathVariable Long id,@RequestHeader(required = false, value = "token") String token){
        cargoFacede.deleteById(id,token);
    }

    @GetMapping("/popular")
    public void popularbank(@RequestHeader(required = false, value = "token") String token){
        cargoFacede.populating(token);
    }
}
