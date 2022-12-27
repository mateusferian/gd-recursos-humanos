package br.com.geradordedevs.gdrecursoshumanos.facedes.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facedes.ColaboradorFacede;
import br.com.geradordedevs.gdrecursoshumanos.mappers.ColaboradorMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import br.com.geradordedevs.gdrecursoshumanos.services.ColaboradorService;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
import br.com.geradordedevs.gdrecursoshumanos.services.TipoDocumentoService;
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

    @Override
    public List<ColaboradorResponseDTO> listar() {
        return mapper.paraListaDto(colaboradorService.listar());
    }

    @Override
    public ColaboradorResponseDTO consultar(Long id) {
        return mapper.paraDto(colaboradorService.consultar(id));
    }

    @Override
    public ColaboradorResponseDTO cadastrar(ColaboradorRequestDTO request) {

        cargoService.consultar(request.getCargo());
        departamentoService.consultar(request.getDepartamento());
        tipoDocumentoService.consultar(request.getTipoDocumento());

        return mapper.paraDto(colaboradorService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public ColaboradorResponseDTO alterar(Long id, ColaboradorRequestDTO request) {

        cargoService.consultar(request.getCargo());
        departamentoService.consultar(request.getDepartamento());
        tipoDocumentoService.consultar(request.getTipoDocumento());

        return mapper.paraDto(colaboradorService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id) {
        colaboradorService.remover(id);
    }

    @Override
    public void popular() {
        colaboradorService.popular();
    }
}
