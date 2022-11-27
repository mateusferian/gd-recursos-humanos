package br.com.geradordedevs.gdrecursoshumanos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping ("/colaboradores")
public class ColaboradorController {

    @Autowired
    private TipoDocumentoController tipoDocumentoController;

    @Autowired
    private DepartamentoController departamentoController ;

    @Autowired
    private CargoController cargoController;


    @GetMapping
    public List<Colaborador> listar(){
         return mockListaColaborador();

    }
    @GetMapping ("/{id}")
public Colaborador consultar(@PathVariable int id ){
        return mockListaColaborador().get(id);
}


 @PostMapping
    public Colaborador cadastrar(@RequestBody Colaborador colaborador){
        return colaborador;
    }

    @PutMapping ("/{id}")
    public List<Colaborador> alterar (@PathVariable int id,@RequestBody Colaborador colaborador){
        List<Colaborador> colaboradores = mockListaColaborador();
        colaboradores.remove(id);
        colaboradores.add(colaborador);
        return colaboradores;
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable int id){
        List<Colaborador> colaboradores = mockListaColaborador();
        colaboradores.remove(id);
    }

   private List<Colaborador> mockListaColaborador(){
       List<Colaborador> listaColaborador = new ArrayList<>();
       listaColaborador.add(new Colaborador(  1,  "mateus",22,new Date(2000-11-20),this.tipoDocumentoController.getTipoDocumentos(2),"50.802.026-8",this.cargoController.getcargos(3),this.departamentoController.getDepartamentos(1), 3000,new Date(2021-10-12),true,"(11) 2153-1920","mateussilva@gmail.com"));
       listaColaborador.add(new Colaborador(  2,  "maria",20,new Date(2002-12-10),this.tipoDocumentoController.getTipoDocumentos(1),"14.545.265-7",this.cargoController.getcargos(2),this.departamentoController.getDepartamentos(3),3000,new Date(20021-11-11),true,"(11) 2153-1918","mariarodrigues@gmail.com"));
       listaColaborador.add(new Colaborador(  3,  "jose",30,new Date(1922-10-11),this.tipoDocumentoController.getTipoDocumentos(3) ,"44.909.686-5",this.cargoController.getcargos(1),this.departamentoController.getDepartamentos(2), 4000,new Date(2021-12-10),true,"(11) 2153-1919","josepaulo@gmail.com"));
       return  listaColaborador;
   }
   public Colaborador getColaboradores(int id){
        List<Colaborador> colaboradores  = this.mockListaColaborador();

       for (Colaborador colaborador : colaboradores) {
           if (colaborador.getId() == id){
               return colaborador;
           }
       }
       return null;
   }
}

