package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.AtestadoRepository;
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


        @GetMapping
        public Iterable<AtestadoEntity> listar(){
            return atestadoRepository.findAll();
        }


        @GetMapping ("/{id}")
        public Optional<AtestadoEntity> consultar(@PathVariable Long id ){
            return atestadoRepository.findById(id);
        }


        @PostMapping
        public AtestadoEntity cadastrar(@RequestBody AtestadoEntity atestadoEntity){
            return atestadoRepository.save(atestadoEntity);
        }


        @PutMapping ("/{id}")
        public AtestadoEntity alterar (@PathVariable long id, @RequestBody AtestadoEntity atestadoEntity){
            atestadoEntity.setId(id);
            return atestadoRepository.save(atestadoEntity);
        }


        @DeleteMapping ("/{id}")
        public void remover (@PathVariable Long id){
            atestadoRepository.deleteById(id);
        }

        private List<AtestadoEntity> mockListaAtestado(){
            List<AtestadoEntity> listaAtestadoEntity = new ArrayList<>();
          //  listaAtestado.add(new Atestado(  1,  "Asma",new Date(2020-10-11),this.colaboradorController.getColaboradores(3)));
            return listaAtestadoEntity;
        }
}
