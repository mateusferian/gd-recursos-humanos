package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.TipoDocumentoFacede;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/tipo-de-documentos")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoFacede tipoDocumentoFacede;

    @GetMapping
    public List<TipoDocumentoResponseDTO> listar(@RequestHeader(required = false,value = "token")String token){
        return tipoDocumentoFacede.listar(token);
    }

    @GetMapping ("/{id}")
    public TipoDocumentoResponseDTO consultar(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token ){
        return tipoDocumentoFacede.consultar(id,token);
    }

    @PostMapping
    public TipoDocumentoResponseDTO cadastrar(@Valid @RequestBody TipoDocumentoRequestDTO request,@RequestHeader(required = false,value = "token")String token){
        return tipoDocumentoFacede.cadastrar(request,token);
    }

    @PutMapping ("/{id}")
    public TipoDocumentoResponseDTO alterar (@PathVariable Long id,@Valid @RequestBody TipoDocumentoRequestDTO request,@RequestHeader(required = false,value = "token")String token){
        return tipoDocumentoFacede.alterar(id, request,token);
    }

    @DeleteMapping ("/{id}")
    public void  remover(@PathVariable  Long id,@RequestHeader(required = false,value = "token")String token) {
        tipoDocumentoFacede.remover(id,token);
    }

    @GetMapping("/popular")
    public void popularBanco(@RequestHeader(required = false,value = "token")String token){
        tipoDocumentoFacede.popular(token);
    }
}
