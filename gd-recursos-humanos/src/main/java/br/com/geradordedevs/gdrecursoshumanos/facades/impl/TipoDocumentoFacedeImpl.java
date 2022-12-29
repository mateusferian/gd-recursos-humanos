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
    public List<TipoDocumentoResponseDTO> listar(String token) {
        tokenService.validar(token);
        return mapper.paraListaDto(tipoDocumentoService.listar());
    }

    @Override
    public TipoDocumentoResponseDTO consultar(Long id,String token) {
        tokenService.validar(token);
        return mapper.paraDto(tipoDocumentoService.consultar(id));
    }

    @Override
    public TipoDocumentoResponseDTO cadastrar(TipoDocumentoRequestDTO request,String token) {
        tokenService.validar(token);
        return mapper.paraDto(tipoDocumentoService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public TipoDocumentoResponseDTO alterar(Long id, TipoDocumentoRequestDTO request,String token) {
        tokenService.validar(token);
        return mapper.paraDto(tipoDocumentoService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id,String token) {
        tokenService.validar(token);
        tipoDocumentoService.remover(id);
    }

    @Override
    public void popular(String token) {
        tokenService.validar(token);
        tipoDocumentoService.popular();
    }
}
