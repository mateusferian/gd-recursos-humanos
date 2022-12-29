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
    public List<DepartamentoResponseDTO> listar(@RequestHeader(required = false,value = "token")String token) {
        return departamentoFacede.listar(token);
    }

    @GetMapping("/{id}")
    public DepartamentoResponseDTO consultar(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token) {
        return departamentoFacede.consultar(id,token);
    }

    @PostMapping
    public DepartamentoResponseDTO cadastrar(@Valid @RequestBody DepartamentoRequestDTO request,@RequestHeader(required = false,value = "token")String token) {
        return departamentoFacede.cadastrar(request,token);
    }

    @PutMapping("/{id}")
    public DepartamentoResponseDTO alterar(@PathVariable Long id,@Valid @RequestBody DepartamentoRequestDTO request,@RequestHeader(required = false,value = "token")String token) {
        return departamentoFacede.alterar(id,request,token);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token) {
        departamentoFacede.remover(id,token);
    }

    @GetMapping("/popular")
    public void popularBanco(@RequestHeader(required = false,value = "token")String token){
        departamentoFacede.popular(token);
    }
}
