package br.com.geradordedevs.gdrecursoshumanos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/atestados")
public class AtestadoController {

          @Autowired
         private ColaboradorController colaboradorController;


        @GetMapping
        public List<Atestado> listar(){
            return mockListaAtestado();
        }


        @GetMapping ("/{id}")
        public Atestado consultar(@PathVariable int id ){
            return mockListaAtestado().get(id);
        }


        @PostMapping
        public Atestado cadastrar(@RequestBody Atestado atestado){

            return atestado;
        }


        @PutMapping ("/{id}")
        public List<Atestado> alterar (@PathVariable int id,@RequestBody Atestado atestado){
            List<Atestado> atestados = mockListaAtestado();
            atestados.remove(id);
            atestados.add(atestado);
            return atestados;
        }


        @DeleteMapping ("/{id}")
        public void remover (@PathVariable int id){
            List<Atestado> atestados = mockListaAtestado();
            atestados.remove(id);
        }

        private List<Atestado> mockListaAtestado(){
            List<Atestado> listaAtestado = new ArrayList<>();
            listaAtestado.add(new Atestado(  1,  "Asma",new Date(2020-10-11),this.colaboradorController.getColaboradores(3)));
            return  listaAtestado;
        }
}
