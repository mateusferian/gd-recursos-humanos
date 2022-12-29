package br.com.geradordedevs.gdrecursoshumanos.controllers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.TipoDocumentoFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping ("/tipo-de-documentos")
public class TipoDocumentoController {

    @Autowired
    private TipoDocumentoFacade tipoDocumentoFacede;

    @GetMapping
    public List<TipoDocumentoResponseDTO> findAll(@RequestHeader(required = false,value = "token")String token){
        return tipoDocumentoFacede.findAll(token);
    }

    @GetMapping ("/{id}")
    public TipoDocumentoResponseDTO findById(@PathVariable Long id,@RequestHeader(required = false,value = "token")String token ){
        return tipoDocumentoFacede.findById(id,token);
    }

    @PostMapping
    public TipoDocumentoResponseDTO save(@Valid @RequestBody TipoDocumentoRequestDTO request,@RequestHeader(required = false,value = "token")String token){
        return tipoDocumentoFacede.save(request,token);
    }

    @PutMapping ("/{id}")
    public TipoDocumentoResponseDTO updateById (@PathVariable Long id,@Valid @RequestBody TipoDocumentoRequestDTO request,@RequestHeader(required = false,value = "token")String token){
        return tipoDocumentoFacede.updateById(id, request,token);
    }

    @DeleteMapping ("/{id}")
    public void  deleteById(@PathVariable  Long id,@RequestHeader(required = false,value = "token")String token) {
        tipoDocumentoFacede.deleteById(id,token);
    }

    @GetMapping("/popular")
    public void popularbank(@RequestHeader(required = false,value = "token")String token){
        tipoDocumentoFacede.popular(token);
    }
}
