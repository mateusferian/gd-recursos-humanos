package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.TipoDocumentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/tipo-de-documentos")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public Iterable<TipoDocumentoEntity> listar(){
        return tipoDocumentoService.listar();

    }
    @GetMapping ("/{id}")
    public TipoDocumentoEntity consultar(@PathVariable Long id ){
        return tipoDocumentoService.consultar(id);


    }


    @PostMapping
    public TipoDocumentoEntity cadastrar(@RequestBody TipoDocumentoEntity tipoDocumentoEntity){

        return tipoDocumentoService.cadastrar(tipoDocumentoEntity);

    }
    @PutMapping ("/{id}")
    public TipoDocumentoEntity alterar (@PathVariable Long id, @RequestBody TipoDocumentoEntity tipoDocumentoEntity){
        return tipoDocumentoService.alterar(id, tipoDocumentoEntity);
    }
    @DeleteMapping ("/{id}")
    public void  remover(@PathVariable  Long id) {
        tipoDocumentoService.remover(id);
    }
}
