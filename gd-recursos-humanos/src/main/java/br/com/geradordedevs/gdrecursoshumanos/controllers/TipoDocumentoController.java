package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.TipoDocumentoRepository;
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

    @GetMapping
    public Iterable<TipoDocumentoEntity> listar(){
        return tipoDocumentoRepository.findAll();

    }
    @GetMapping ("/{id}")
    public Optional<TipoDocumentoEntity> consultar(@PathVariable Long id ){
        return tipoDocumentoRepository.findById(id);


    }


    @PostMapping
    public TipoDocumentoEntity cadastrar(@RequestBody TipoDocumentoEntity tipoDocumentoEntity){

        return tipoDocumentoRepository.save(tipoDocumentoEntity);

    }
    @PutMapping ("/{id}")
    public TipoDocumentoEntity alterar (@PathVariable Long id, @RequestBody TipoDocumentoEntity tipoDocumentoEntity){
        tipoDocumentoEntity.setId(id);
        return tipoDocumentoRepository.save(tipoDocumentoEntity);
    }
    @DeleteMapping ("/{id}")
    public void  remover(@PathVariable  Long id) {
        tipoDocumentoRepository.deleteById(id);
    }
}
