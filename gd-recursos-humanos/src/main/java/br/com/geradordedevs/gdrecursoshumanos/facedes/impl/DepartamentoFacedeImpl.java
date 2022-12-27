package br.com.geradordedevs.gdrecursoshumanos.facedes.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facedes.DepartamentoFacede;
import br.com.geradordedevs.gdrecursoshumanos.mappers.DepartamentoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DepartamentoFacedeImpl implements DepartamentoFacede {

    @Autowired
    private DepartamentoMapper mapper;

    @Autowired
    private DepartamentoService departamentoService;

    @Autowired
    private TokenService tokenService;

    @Override
    public List<DepartamentoResponseDTO> listar(String token) {
        tokenService.validar(token);
        return mapper.paraListaDto(departamentoService.listar());
    }

    @Override
    public DepartamentoResponseDTO consultar(Long id,String token) {
        tokenService.validar(token);
        return mapper.paraDto(departamentoService.consultar(id));
    }

    @Override
    public DepartamentoResponseDTO cadastrar(DepartamentoRequestDTO request,String token) {
        tokenService.validar(token);
        return mapper.paraDto(departamentoService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public DepartamentoResponseDTO alterar(Long id, DepartamentoRequestDTO request,String token) {
        tokenService.validar(token);
        return mapper.paraDto(departamentoService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id,String token) {
        tokenService.validar(token);
        departamentoService.remover(id);
    }

    @Override
    public void popular(String token) {
        tokenService.validar(token);
        departamentoService.popular();
    }
}
