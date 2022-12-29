package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.AtestadoFacade;
import br.com.geradordedevs.gdrecursoshumanos.mappers.AtestadoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.AtestadoService;
import br.com.geradordedevs.gdrecursoshumanos.services.ColaboradorService;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AtestadoFacedeImpl implements AtestadoFacade {

    @Autowired
    private AtestadoMapper mapper;

    @Autowired
    private AtestadoService atestadoService;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private TokenService tokenService;

    @Override
    public List<AtestadoResponseDTO> findAll(String token) {
        tokenService.validate(token);
        return mapper.toDtoList(atestadoService.findAll());
    }

    @Override
    public AtestadoResponseDTO findById(Long id,String token) {
        tokenService.validate(token);
        return mapper.toDto(atestadoService.findById(id));
    }

    @Override
    public AtestadoResponseDTO save(AtestadoRequestDTO request,String token) {
        tokenService.validate(token);
        colaboradorService.findById(request.getColaborador());
        return mapper.toDto(atestadoService.save(mapper.toEntity(request)));
    }

    @Override
    public AtestadoResponseDTO updateById(Long id, AtestadoRequestDTO request,String token) {
        tokenService.validate(token);
        return mapper.toDto(atestadoService.updateById(id,mapper.toEntity(request)));
    }

    @Override
    public void deleteById(Long id,String token) {
        tokenService.validate(token);
        atestadoService.deleteById(id);
    }

    @Override
    public void popular(String token) {
        tokenService.validate(token);
        atestadoService.popular();
    }
}
