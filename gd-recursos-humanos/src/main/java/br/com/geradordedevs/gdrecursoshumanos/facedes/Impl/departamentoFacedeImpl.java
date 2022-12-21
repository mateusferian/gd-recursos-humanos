package br.com.geradordedevs.gdrecursoshumanos.facedes.Impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facedes.DepartamentoFacede;
import br.com.geradordedevs.gdrecursoshumanos.mappers.DepartamentoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class departamentoFacedeImpl implements DepartamentoFacede {

    @Autowired
    private DepartamentoMapper mapper;

    @Autowired
    private DepartamentoService departamentoService;

    @Override
    public List<DepartamentoResponseDTO> listar() {
        return mapper.paraListaDto(departamentoService.listar());
    }

    @Override
    public DepartamentoResponseDTO consultar(Long id) {
        return mapper.paraDto(departamentoService.consultar(id));
    }

    @Override
    public DepartamentoResponseDTO cadastrar(DepartamentoRequestDTO request) {
        return mapper.paraDto(departamentoService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public DepartamentoResponseDTO alterar(Long id, DepartamentoRequestDTO request) {
        return mapper.paraDto(departamentoService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id) {
        departamentoService.remover(id);
    }

    @Override
    public void popular() {
        departamentoService.popular();

    }
}
