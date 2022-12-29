package br.com.geradordedevs.gdrecursoshumanos.controllers;


import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.ColaboradorFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/colaboradores")
public class ColaboradorController {

    @Autowired
    private ColaboradorFacade colaboradorFacede;

    @GetMapping
    public List<ColaboradorResponseDTO> findAll(@RequestHeader(required = false,value = "token")String token){
        return colaboradorFacede.findAll(token);
    }

    @GetMapping ("/{id}")
    public ColaboradorResponseDTO findById(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token ){
        return colaboradorFacede.findById(id,token);
    }

    @PostMapping
    public ColaboradorResponseDTO save(@Valid @RequestBody ColaboradorRequestDTO request, @RequestHeader(required = false,value = "token")String token){
        return colaboradorFacede.save(request,token);
    }

    @PutMapping ("/{id}")
    public ColaboradorResponseDTO updateById (@PathVariable Long id,@Valid @RequestBody ColaboradorRequestDTO request,@RequestHeader(required = false,value = "token")String token){
        return  colaboradorFacede.updateById(id, request,token);
    }

    @DeleteMapping ("/{id}")
    public void deleteById (@PathVariable Long id,@RequestHeader(required = false,value = "token")String token){
        colaboradorFacede.deleteById(id,token);
    }

    @GetMapping("/popular")
    public void popularbank(@RequestHeader(required = false,value = "token")String token){
        colaboradorFacede.popular(token);
    }
}

