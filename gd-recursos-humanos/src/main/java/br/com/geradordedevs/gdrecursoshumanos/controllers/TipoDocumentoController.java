package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.facedes.TipoDocumentoFacede;
import br.com.geradordedevs.gdrecursoshumanos.repositories.TipoDocumentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping ("/tipo-de-documentos")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoFacede tipoDocumentoFacede;

    @GetMapping
    public List<TipoDocumentoResponseDTO> listar(){
        return tipoDocumentoFacede.listar();
    }

    @GetMapping ("/{id}")
    public TipoDocumentoResponseDTO consultar(@PathVariable Long id ){
        return tipoDocumentoFacede.consultar(id);
    }

    @PostMapping
    public TipoDocumentoResponseDTO cadastrar(@Valid @RequestBody TipoDocumentoRequestDTO request){
        return tipoDocumentoFacede.cadastrar(request);
    }

    @PutMapping ("/{id}")
    public TipoDocumentoResponseDTO alterar (@PathVariable Long id,@Valid @RequestBody TipoDocumentoRequestDTO request){
        return tipoDocumentoFacede.alterar(id, request);
    }

    @DeleteMapping ("/{id}")
    public void  remover(@PathVariable  Long id) {
        tipoDocumentoFacede.remover(id);
    }

    @GetMapping("/popular")
    public void popularBanco(){
        tipoDocumentoFacede.popular();
    }
}
