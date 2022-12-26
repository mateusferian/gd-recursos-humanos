package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.mappers.TipoDocumentoMapper;
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

    @Override
    public Iterable<TipoDocumentoEntity> listar() {
        log.info("listando tipo de documentos");
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumentoEntity consultar(Long id) {
        log.info("obtendo informacoes de tipo de documento {}", id);
        return tipoDocumentoRepository.findById(id).orElse(new TipoDocumentoEntity());
    }

    @Override
    public TipoDocumentoEntity cadastrar(TipoDocumentoEntity entity) {
        log.info("cadastrando um novo tipo de documento {}",entity);
        return  tipoDocumentoRepository.save(entity);
    }

    @Override
    public TipoDocumentoEntity alterar(Long id, TipoDocumentoEntity entity) {
        log.info("alterando o tipo de documento de id {} com novas informacoes: {}", id, entity);
        entity.setId(id);
        return  tipoDocumentoRepository.save(entity);
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
