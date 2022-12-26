package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.facedes.AtestadoFacede;
import br.com.geradordedevs.gdrecursoshumanos.repositories.AtestadoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.AtestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/atestados")
public class AtestadoController {

        @Autowired
        private AtestadoFacede atestadoFacede;

        @GetMapping
        public List<AtestadoResponseDTO> listar(){
            return atestadoFacede.listar();
        }

        @GetMapping ("/{id}")
        public AtestadoResponseDTO consultar(@PathVariable Long id ){
            return atestadoFacede.consultar(id);
        }

        @PostMapping
        public AtestadoResponseDTO cadastrar(@Valid @RequestBody AtestadoRequestDTO requesty){
            return atestadoFacede.cadastrar(requesty);
        }

        @PutMapping ("/{id}")
        public AtestadoResponseDTO alterar (@PathVariable long id,@Valid @RequestBody AtestadoRequestDTO request){
            return  atestadoFacede.alterar(id, request);
        }

        @DeleteMapping ("/{id}")
        public void remover (@PathVariable Long id){
            atestadoFacede.remover(id);
        }

         @GetMapping("/popular")
        public void popularBanco(){
             atestadoFacede.popular();
    }
}
