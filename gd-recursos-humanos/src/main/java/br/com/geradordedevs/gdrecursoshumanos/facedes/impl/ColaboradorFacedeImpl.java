package br.com.geradordedevs.gdrecursoshumanos.facedes.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facedes.ColaboradorFacede;
import br.com.geradordedevs.gdrecursoshumanos.mappers.ColaboradorMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ColaboradorFacedeImpl implements ColaboradorFacede {

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
    public List<ColaboradorResponseDTO> listar(String token) {
        tokenService.validar(token);
        return mapper.paraListaDto(colaboradorService.listar());
    }

    @Override
    public ColaboradorResponseDTO consultar(Long id,String token) {
        tokenService.validar(token);
        return mapper.paraDto(colaboradorService.consultar(id));
    }

    @Override
    public ColaboradorResponseDTO cadastrar(ColaboradorRequestDTO request,String token) {

        tokenService.validar(token);
        cargoService.consultar(request.getCargo());
        departamentoService.consultar(request.getDepartamento());
        tipoDocumentoService.consultar(request.getTipoDocumento());

        return mapper.paraDto(colaboradorService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public ColaboradorResponseDTO alterar(Long id, ColaboradorRequestDTO request,String token) {

        tokenService.validar(token);
        cargoService.consultar(request.getCargo());
        departamentoService.consultar(request.getDepartamento());
        tipoDocumentoService.consultar(request.getTipoDocumento());

        return mapper.paraDto(colaboradorService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id,String token) {
        tokenService.validar(token);
        colaboradorService.remover(id);
    }

    @Override
    public void popular(String token) {
        tokenService.validar(token);
        colaboradorService.popular();
    }
}
