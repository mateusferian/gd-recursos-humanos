package br.com.geradordedevs.gdrecursoshumanos.facedes.Impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facedes.TipoDocumentoFacede;
import br.com.geradordedevs.gdrecursoshumanos.mappers.TipoDocumentoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoDocumentoFacedeImpl implements TipoDocumentoFacede{

    @Autowired
    private TipoDocumentoMapper mapper;

    @Autowired
    private TipoDocumentoService tipoDocumentoService;

    @Override
    public List<TipoDocumentoResponseDTO> listar() {
        return mapper.paraListaDto(tipoDocumentoService.listar());
    }

    @Override
    public TipoDocumentoResponseDTO consultar(Long id) {
        return mapper.paraDto(tipoDocumentoService.consultar(id));
    }

    @Override
    public TipoDocumentoResponseDTO cadastrar(TipoDocumentoRequestDTO request) {
        return mapper.paraDto(tipoDocumentoService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public TipoDocumentoResponseDTO alterar(Long id, TipoDocumentoRequestDTO request) {
        return mapper.paraDto(tipoDocumentoService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id) {
        tipoDocumentoService.remover(id);
    }

    @Override
    public void popular() {
        tipoDocumentoService.popular();
    }
}
