package br.com.geradordedevs.gdrecursoshumanos.controllers;

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
        public AtestadoRepository atestadoRepository;
        @Autowired
        private AtestadoService atestadoService;


        @GetMapping
        public Iterable<AtestadoEntity> listar(){
            return atestadoService.listar();
        }


        @GetMapping ("/{id}")
        public AtestadoEntity consultar(@PathVariable Long id ){
            return atestadoService.consultar(id);
        }


        @PostMapping
        public AtestadoEntity cadastrar(@RequestBody AtestadoEntity atestadoEntity){
            return atestadoService.cadastrar(atestadoEntity);
        }


        @PutMapping ("/{id}")
        public AtestadoEntity alterar (@PathVariable long id, @RequestBody AtestadoEntity atestadoEntity){
            return  atestadoService.alterar(id, atestadoEntity);
        }


        @DeleteMapping ("/{id}")
        public void remover (@PathVariable Long id){
            atestadoService.remover(id);
        }


    @GetMapping("/popular")
    public Iterable<AtestadoEntity> popularBanco(){
        atestadoService.popular();
        return atestadoService.listar();
    }
}
