package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.AtestadoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.AtestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atestados")
public class AtestadoController {

        @Autowired
        private AtestadoService atestadoService;

        @GetMapping
        public List<AtestadoResponseDTO> listar(){
            return atestadoService.listar();
        }

        @GetMapping ("/{id}")
        public AtestadoResponseDTO consultar(@PathVariable Long id ){
            return atestadoService.consultar(id);
        }

        @PostMapping
        public AtestadoResponseDTO cadastrar(@RequestBody AtestadoRequestDTO requesty){
            return atestadoService.cadastrar(requesty);
        }

        @PutMapping ("/{id}")
        public AtestadoResponseDTO alterar (@PathVariable long id, @RequestBody AtestadoRequestDTO request){
            return  atestadoService.alterar(id, request);
        }

        @DeleteMapping ("/{id}")
        public void remover (@PathVariable Long id){
            atestadoService.remover(id);
        }

         @GetMapping("/popular")
        public List<AtestadoResponseDTO> popularBanco(){
        atestadoService.popular();
             return atestadoService.listar();
    }
}
