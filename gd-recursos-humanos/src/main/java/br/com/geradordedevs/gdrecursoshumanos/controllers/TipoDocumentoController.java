package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
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
    private TipoDocumentoService tipoDocumentoService;

    @GetMapping
    public List<TipoDocumentoResponseDTO> listar(){
        return tipoDocumentoService.listar();
    }

    @GetMapping ("/{id}")
    public TipoDocumentoResponseDTO consultar(@PathVariable Long id ){
        return tipoDocumentoService.consultar(id);
    }

    @PostMapping
    public TipoDocumentoResponseDTO cadastrar(@RequestBody TipoDocumentoRequestDTO request){
        return tipoDocumentoService.cadastrar(request);
    }

    @PutMapping ("/{id}")
    public TipoDocumentoResponseDTO alterar (@PathVariable Long id, @RequestBody TipoDocumentoRequestDTO request){
        return tipoDocumentoService.alterar(id, request);
    }

    @DeleteMapping ("/{id}")
    public void  remover(@PathVariable  Long id) {
        tipoDocumentoService.remover(id);
    }

    @GetMapping("/popular")
    public List<TipoDocumentoResponseDTO> popularBanco(){
        tipoDocumentoService.popular();
        return tipoDocumentoService.listar();
    }
}
