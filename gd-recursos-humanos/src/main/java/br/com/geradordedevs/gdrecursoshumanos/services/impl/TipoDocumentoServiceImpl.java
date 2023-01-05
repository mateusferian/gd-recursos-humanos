package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.TipoDocumentoException;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.TipoDocumentoEnum;
import br.com.geradordedevs.gdrecursoshumanos.repositories.TipoDocumentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.TipoDocumentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public Iterable<TipoDocumentoEntity> findAll() {
        log.info("listing type of documents");
        return tipoDocumentoRepository.findAll();
    }

    @Override
    public TipoDocumentoEntity findById(Long id) {
        log.info("getting document type information {}", id);
        return tipoDocumentoRepository.findById(id).orElseThrow(() -> new TipoDocumentoException(TipoDocumentoEnum.DOCUMENT_TYPE_NOT_FOUND));
    }

    @Override
    public TipoDocumentoEntity save(TipoDocumentoEntity entity) {
        log.info("registering a new type of document {}",entity);
        return  tipoDocumentoRepository.save(entity);
    }

    @Override
    public TipoDocumentoEntity update(Long id, TipoDocumentoEntity entity) {
        log.info("changing the document type of id {} with new information: {}", id, entity);
        findById(id);
        entity.setId(id);
        return  tipoDocumentoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        findById(id);
        log.info("removing the document type from id {}", id);
       tipoDocumentoRepository.deleteById(id);
    }

    @Override
    public void populating() {
        log.info("populating the document type database for testing");
        tipoDocumentoRepository.save((new TipoDocumentoEntity("RG")));
        tipoDocumentoRepository.save((new TipoDocumentoEntity("CPF")));
        tipoDocumentoRepository.save((new TipoDocumentoEntity("CNJP")));
    }
}
