package br.com.geradordedevs.gdrecursoshumanos.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cargos")
public class CargoController {


    @GetMapping
    public List<Cargo> listar(){
        return mockListaCargo();

    }
    @GetMapping ("/{id}")
    public Cargo consultar(@PathVariable int id ){
        return mockListaCargo().get(id);


    }

    @PostMapping
    public Cargo cadastrar(@RequestBody Cargo cargo){

        return cargo;

    }
    @PutMapping ("/{id}")
    //precisa arrumar essa parte//
    public List<Cargo> alterar (@PathVariable int id,@RequestBody Cargo cargo){
        List<Cargo> cargos = mockListaCargo();
        cargos.remove(id);
        cargos.add(cargo);
        return cargos;
    }

    @DeleteMapping ("/{id}")
    public void remover (@PathVariable int id){
        List<Cargo> cargos = mockListaCargo();
        cargos.remove(id);
    }

    private List<Cargo> mockListaCargo(){
        List<Cargo> listaCargo = new ArrayList<>();
        listaCargo.add(new Cargo(  1,  "Desenvolvedor backand"));
        listaCargo.add(new Cargo(  2,  "Desenvolvedor frontand"));
        listaCargo.add(new Cargo(  3,  "Desenvolvedor ful stack"));
        return  listaCargo;
    }
    public Cargo getcargos(int id){
        List<Cargo> cargos =  this.mockListaCargo();
        for (Cargo cargo: cargos) {
            if (cargo.getId() ==  id ){
                return cargo;
            }
        }
        return  null;
    }
}
