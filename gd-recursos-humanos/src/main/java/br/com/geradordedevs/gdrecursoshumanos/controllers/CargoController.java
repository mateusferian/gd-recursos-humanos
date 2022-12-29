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
    public List<CargoResponseDTO> listar(@RequestHeader(required = false, value = "token") String token){
        return cargoFacede.listar(token);
    }

    @GetMapping ("/{id}")
    public CargoResponseDTO consultar(@PathVariable Long id, @RequestHeader(required = false, value = "token") String token){
        return cargoFacede.consultar(id,token);
    }

    @PostMapping
    public CargoResponseDTO cadastrar(@Valid @RequestBody CargoRequestDTO request,@RequestHeader(required = false, value = "token") String token){
        return cargoFacede.cadastrar(request,token);
    }

    @PutMapping ("/{id}")
    public CargoResponseDTO alterar (@PathVariable Long id,@Valid @RequestBody CargoRequestDTO request,@RequestHeader(required = false, value = "token") String token){
        return cargoFacede.alterar(id, request,token);
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable Long id,@RequestHeader(required = false, value = "token") String token){
        cargoFacede.remover(id,token);
    }

    @GetMapping("/popular")
    public void popularBanco(@RequestHeader(required = false, value = "token") String token){
        cargoFacede.popular(token);
    }
}
