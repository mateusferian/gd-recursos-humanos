package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.DepartamentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/departamentos")
public class DepartamentoController {

    @Autowired
    private DepartamentoFacade departamentoFacede;

    @GetMapping
    public List<DepartamentoResponseDTO> findAll(@RequestHeader(required = false,value = "token")String token) {
        return departamentoFacede.findAll(token);
    }

    @GetMapping("/{id}")
    public DepartamentoResponseDTO findById(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token) {
        return departamentoFacede.findById(id,token);
    }

    @PostMapping
    public DepartamentoResponseDTO save(@Valid @RequestBody DepartamentoRequestDTO request,@RequestHeader(required = false,value = "token")String token) {
        return departamentoFacede.save(request,token);
    }

    @PutMapping("/{id}")
    public DepartamentoResponseDTO update(@PathVariable Long id,@Valid @RequestBody DepartamentoRequestDTO request,@RequestHeader(required = false,value = "token")String token) {
        return departamentoFacede.update(id,request,token);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token) {
        departamentoFacede.deleteById(id,token);
    }

    @GetMapping("/popular")
    public void popularbank(@RequestHeader(required = false,value = "token")String token){
        departamentoFacede.populating(token);
    }
}
