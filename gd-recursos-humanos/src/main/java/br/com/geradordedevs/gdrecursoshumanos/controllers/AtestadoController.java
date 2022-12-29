package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.AtestadoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/atestados")
public class AtestadoController {

        @Autowired
        private AtestadoFacade atestadoFacede;

        @GetMapping
        public List<AtestadoResponseDTO> findAll(@RequestHeader(required = false,value = "token")String token){
            return atestadoFacede.findAll(token);
        }

        @GetMapping ("/{id}")
        public AtestadoResponseDTO findById(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token ){
            return atestadoFacede.findById(id,token);
        }

        @PostMapping
        public AtestadoResponseDTO save(@Valid @RequestBody AtestadoRequestDTO requesty,@RequestHeader(required = false,value = "token")String token){
            return atestadoFacede.save(requesty,token);
        }

        @PutMapping ("/{id}")
        public AtestadoResponseDTO updateById (@PathVariable long id,@Valid @RequestBody AtestadoRequestDTO request,@RequestHeader(required = false,value = "token")String token){
            return  atestadoFacede.updateById(id, request,token);
        }

        @DeleteMapping ("/{id}")
        public void deleteById (@PathVariable Long id,@RequestHeader(required = false,value = "token")String token){
            atestadoFacede.deleteById(id,token);
        }

         @GetMapping("/popular")
        public void popularbank(@RequestHeader(required = false,value = "token")String token){
             atestadoFacede.popular(token);
    }
}
