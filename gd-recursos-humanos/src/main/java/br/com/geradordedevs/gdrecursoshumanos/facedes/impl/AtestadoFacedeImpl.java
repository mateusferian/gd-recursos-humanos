package br.com.geradordedevs.gdrecursoshumanos.facedes.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facedes.AtestadoFacede;
import br.com.geradordedevs.gdrecursoshumanos.mappers.AtestadoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.AtestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class AtestadoFacedeImpl implements AtestadoFacede {

    @Autowired
    private AtestadoMapper mapper;

    @Autowired
    private AtestadoService atestadoService;

    @Override
    public List<AtestadoResponseDTO> listar() {
        return mapper.paraListaDto(atestadoService.listar());
    }

    @Override
    public AtestadoResponseDTO consultar(Long id) {
        return mapper.paraDto(atestadoService.consultar(id));
    }

    @Override
    public AtestadoResponseDTO cadastrar(AtestadoRequestDTO request) {
        return mapper.paraDto(atestadoService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public AtestadoResponseDTO alterar(Long id, AtestadoRequestDTO request) {
        return mapper.paraDto(atestadoService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id) {
        atestadoService.remover(id);
    }

    @Override
    public void popular() {
        atestadoService.popular();
    }
}
