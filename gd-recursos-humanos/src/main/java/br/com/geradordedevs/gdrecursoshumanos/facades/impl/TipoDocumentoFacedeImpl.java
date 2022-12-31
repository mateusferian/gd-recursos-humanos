package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.TipoDocumentoFacade;
import br.com.geradordedevs.gdrecursoshumanos.mappers.TipoDocumentoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.TipoDocumentoService;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoDocumentoFacedeImpl implements TipoDocumentoFacade {

    @Autowired
    private TipoDocumentoMapper mapper;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private TokenService tokenService;

    @Override
    public List<TipoDocumentoResponseDTO> findAll(String token) {
        tokenService.validate(token);
        return mapper.toDtoList(tipoDocumentoService.findAll());
    }

    @Override
    public TipoDocumentoResponseDTO findById(Long id,String token) {
        tokenService.validate(token);
        return mapper.toDto(tipoDocumentoService.findById(id));
    }

    @Override
    public TipoDocumentoResponseDTO save(TipoDocumentoRequestDTO request,String token) {
        tokenService.validate(token);
        return mapper.toDto(tipoDocumentoService.save(mapper.toEntity(request)));
    }

    @Override
    public TipoDocumentoResponseDTO update(Long id, TipoDocumentoRequestDTO request,String token) {
        tokenService.validate(token);
        return mapper.toDto(tipoDocumentoService.update(id,mapper.toEntity(request)));
    }

    @Override
    public void deleteById(Long id,String token) {
        tokenService.validate(token);
        tipoDocumentoService.deleteById(id);
    }

    @Override
    public void populating(String token) {
        tokenService.validate(token);
        tipoDocumentoService.populating();
    }
}
