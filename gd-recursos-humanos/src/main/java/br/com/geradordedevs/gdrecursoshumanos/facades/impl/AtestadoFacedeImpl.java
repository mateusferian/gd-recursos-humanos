package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.AtestadoFacede;
import br.com.geradordedevs.gdrecursoshumanos.mappers.AtestadoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.AtestadoService;
import br.com.geradordedevs.gdrecursoshumanos.services.ColaboradorService;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AtestadoFacedeImpl implements AtestadoFacede {

    @Autowired
    private AtestadoMapper mapper;

    @Autowired
    private AtestadoService atestadoService;

    @Autowired
    private ColaboradorService colaboradorService;

    @Autowired
    private TokenService tokenService;

    @Override
    public List<AtestadoResponseDTO> listar(String token) {
        tokenService.validar(token);
        return mapper.paraListaDto(atestadoService.listar());
    }

    @Override
    public AtestadoResponseDTO consultar(Long id,String token) {
        tokenService.validar(token);
        return mapper.paraDto(atestadoService.consultar(id));
    }

    @Override
    public AtestadoResponseDTO cadastrar(AtestadoRequestDTO request,String token) {
        tokenService.validar(token);
        colaboradorService.consultar(request.getColaborador());
        return mapper.paraDto(atestadoService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public AtestadoResponseDTO alterar(Long id, AtestadoRequestDTO request,String token) {
        tokenService.validar(token);
        return mapper.paraDto(atestadoService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id,String token) {
        tokenService.validar(token);
        atestadoService.remover(id);
    }

    @Override
    public void popular(String token) {
        tokenService.validar(token);
        atestadoService.popular();
    }
}
