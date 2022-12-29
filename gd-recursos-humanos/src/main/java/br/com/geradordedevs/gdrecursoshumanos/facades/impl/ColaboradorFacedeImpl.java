package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.ColaboradorFacade;
import br.com.geradordedevs.gdrecursoshumanos.mappers.ColaboradorMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ColaboradorFacedeImpl implements ColaboradorFacade {

    @Autowired
    private ColaboradorMapper mapper;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Autowired
    private TokenService tokenService;

    @Override
    public List<ColaboradorResponseDTO> findAll(String token) {
        tokenService.validate(token);
        return mapper.toDtoList(colaboradorService.findAll());
    }

    @Override
    public ColaboradorResponseDTO findById(Long id,String token) {
        tokenService.validate(token);
        return mapper.toDto(colaboradorService.findById(id));
    }

    @Override
    public ColaboradorResponseDTO save(ColaboradorRequestDTO request,String token) {

        tokenService.validate(token);
        cargoService.findById(request.getCargo());
        departamentoService.findById(request.getDepartamento());
        tipoDocumentoService.findById(request.getTipoDocumento());

        return mapper.toDto(colaboradorService.save(mapper.toEntity(request)));
    }

    @Override
    public ColaboradorResponseDTO updateById(Long id, ColaboradorRequestDTO request,String token) {

        tokenService.validate(token);
        cargoService.findById(request.getCargo());
        departamentoService.findById(request.getDepartamento());
        tipoDocumentoService.findById(request.getTipoDocumento());

        return mapper.toDto(colaboradorService.updateById(id,mapper.toEntity(request)));
    }

    @Override
    public void deleteById(Long id,String token) {
        tokenService.validate(token);
        colaboradorService.deleteById(id);
    }

    @Override
    public void popular(String token) {
        tokenService.validate(token);
        colaboradorService.popular();
    }
}
