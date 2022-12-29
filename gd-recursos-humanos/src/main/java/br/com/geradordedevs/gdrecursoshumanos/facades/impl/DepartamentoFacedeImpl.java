package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.DepartamentoFacade;
import br.com.geradordedevs.gdrecursoshumanos.mappers.DepartamentoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DepartamentoFacedeImpl implements DepartamentoFacade {

    @Autowired
    private DepartamentoMapper mapper;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private TokenService tokenService;

    @Override
    public List<DepartamentoResponseDTO> findAll(String token) {
        tokenService.validate(token);
        return mapper.toDtoList(departamentoService.findAll());
    }

    @Override
    public DepartamentoResponseDTO findById(Long id,String token) {
        tokenService.validate(token);
        return mapper.toDto(departamentoService.findById(id));
    }

    @Override
    public DepartamentoResponseDTO save(DepartamentoRequestDTO request,String token) {
        tokenService.validate(token);
        return mapper.toDto(departamentoService.save(mapper.toEntity(request)));
    }

    @Override
    public DepartamentoResponseDTO update(Long id, DepartamentoRequestDTO request,String token) {
        tokenService.validate(token);
        return mapper.toDto(departamentoService.update(id,mapper.toEntity(request)));
    }

    @Override
    public void deleteById(Long id,String token) {
        tokenService.validate(token);
        departamentoService.deleteById(id);
    }

    @Override
    public void popular(String token) {
        tokenService.validate(token);
        departamentoService.popular();
    }
}
