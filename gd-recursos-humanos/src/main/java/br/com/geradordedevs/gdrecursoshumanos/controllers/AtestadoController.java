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
        public List<AtestadoResponseDTO> listar(@RequestHeader(required = false,value = "token")String token){
            return atestadoFacede.listar(token);
        }

        @GetMapping ("/{id}")
        public AtestadoResponseDTO consultar(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token ){
            return atestadoFacede.consultar(id,token);
        }

        @PostMapping
        public AtestadoResponseDTO cadastrar(@Valid @RequestBody AtestadoRequestDTO requesty,@RequestHeader(required = false,value = "token")String token){
            return atestadoFacede.cadastrar(requesty,token);
        }

        @PutMapping ("/{id}")
        public AtestadoResponseDTO alterar (@PathVariable long id,@Valid @RequestBody AtestadoRequestDTO request,@RequestHeader(required = false,value = "token")String token){
            return  atestadoFacede.alterar(id, request,token);
        }

        @DeleteMapping ("/{id}")
        public void remover (@PathVariable Long id,@RequestHeader(required = false,value = "token")String token){
            atestadoFacede.remover(id,token);
        }

         @GetMapping("/popular")
        public void popularBanco(@RequestHeader(required = false,value = "token")String token){
             atestadoFacede.popular(token);
    }
}
