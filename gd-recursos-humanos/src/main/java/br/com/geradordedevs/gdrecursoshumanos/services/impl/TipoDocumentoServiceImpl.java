package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.mapper.TipoDocumentoMapper;
import br.com.geradordedevs.gdrecursoshumanos.repositories.TipoDocumentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.TipoDocumentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TipoDocumentoServiceImpl implements TipoDocumentoService {
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    @Autowired
    private TipoDocumentoMapper mapper;
    @Override
    public List<TipoDocumentoResponseDTO> listar() {
        log.info("listando tipo de documentos");
        List<TipoDocumentoEntity> tipoDocumentoEntities = new ArrayList<>();
        for (TipoDocumentoEntity tipoDocumentoEntity: tipoDocumentoRepository.findAll()) {
            tipoDocumentoEntities.add(tipoDocumentoEntity);
        }
        return mapper.paraListaDto(tipoDocumentoEntities);
    }
    @Override
    public TipoDocumentoResponseDTO consultar(Long id) {
        log.info("obtendo informacoes de tipo de documento {}", id);
        return mapper.paraDto(tipoDocumentoRepository.findById(id).orElse(new TipoDocumentoEntity()));
    }
    @Override
    public TipoDocumentoResponseDTO cadastrar(TipoDocumentoRequestDTO request) {
        log.info("cadastrando um novo tipo de documento {}",request);
        return  mapper.paraDto(tipoDocumentoRepository.save(mapper.paraEntidade(request)));
    }
    @Override
    public TipoDocumentoResponseDTO alterar(Long id, TipoDocumentoRequestDTO request) {
        log.info("alterando o tipo de documento de id {} com novas informacoes: {}", id, request);
            TipoDocumentoEntity tipoDocumento = mapper.paraEntidade(request);
            tipoDocumento.setId(id);
        return  mapper.paraDto(tipoDocumentoRepository.save(tipoDocumento));
    }
    @Override
    public void remover(Long id) {
        log.info("removendo o tipo de documento de id {}", id);
       tipoDocumentoRepository.deleteById(id);
    }
    @Override
    public void popular() {
        log.info("populando o banco de dados de tipo de documentos para teste");
        tipoDocumentoRepository.save((new TipoDocumentoEntity("RG")));
        tipoDocumentoRepository.save((new TipoDocumentoEntity("CPF")));
        tipoDocumentoRepository.save((new TipoDocumentoEntity("CNJP")));
    }
}
