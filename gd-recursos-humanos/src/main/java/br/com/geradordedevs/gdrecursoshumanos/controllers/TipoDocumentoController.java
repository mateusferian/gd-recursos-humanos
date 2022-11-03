package br.com.geradordedevs.gdrecursoshumanos.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping ("/tiposdocumentos")
public class TipoDocumentoController {

    @GetMapping
    public List<TipoDocumento> listar(){
        return mockListaTipoDocumento();

    }
    @GetMapping ("/{id}")
    public TipoDocumento consultar(@PathVariable int id ){
        return mockListaTipoDocumento().get(id);


    }


    @PostMapping
    public TipoDocumento cadastrar(@RequestBody TipoDocumento tipoDocumento){

        return tipoDocumento;

    }
    @PutMapping ("/{id}")
    //precisa arrumar essa parte//
    public List<TipoDocumento> alterar (@PathVariable int id,@RequestBody TipoDocumento tipoDocumento){
        List<TipoDocumento> tipoDocumentos = mockListaTipoDocumento();
        tipoDocumentos.remove(id);
        tipoDocumentos.add(tipoDocumento);
        return tipoDocumentos;
    }
    @DeleteMapping ("/{id}")
    public void  remover(@PathVariable  int id) {
        List<TipoDocumento> tipoDocumentos = mockListaTipoDocumento();
        tipoDocumentos.remove(id);
    }

    private List<TipoDocumento> mockListaTipoDocumento(){
        List<TipoDocumento> listaTipoDocumento = new ArrayList<>();
        listaTipoDocumento.add(new TipoDocumento(  1,  "RG"));
        listaTipoDocumento.add(new TipoDocumento(  2,  "RG"));
        listaTipoDocumento.add(new TipoDocumento(  3,  "RG"));
        return  listaTipoDocumento;
    }

    public TipoDocumento getTipoDocumentos(int id){
        List<TipoDocumento> tiposDocumentos = this.mockListaTipoDocumento();


        for (TipoDocumento tipoDocumento: tiposDocumentos) {
            if(tipoDocumento.getId() == id){
                return tipoDocumento;
            }
        }

        return null;
    }

}
