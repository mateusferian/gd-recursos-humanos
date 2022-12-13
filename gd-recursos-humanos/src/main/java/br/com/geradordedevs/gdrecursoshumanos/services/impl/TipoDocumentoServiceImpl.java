package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
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
    public Iterable<TipoDocumentoEntity> listar() {
        log.info("listando tipo de documentos");
        return tipoDocumentoRepository.findAll();
    }
    @Override
    public TipoDocumentoEntity consultar(Long id) {
        log.info("obtendo informações de tipo de documento {}", id);
        return tipoDocumentoRepository.findById(id).orElse(new TipoDocumentoEntity());
    }
    @Override
    public TipoDocumentoEntity cadastrar(TipoDocumentoEntity tipoDocumentoEntity) {
        log.info("cadastrando um novo tipo de documento {}", tipoDocumentoEntity);
        return  tipoDocumentoRepository.save(tipoDocumentoEntity);
    }
    @Override
    public TipoDocumentoEntity alterar(Long id, TipoDocumentoEntity tipoDocumentoEntity) {
        log.info("alterando o tipo de documento de id {} com novas informações: {}", id, tipoDocumentoEntity);
        tipoDocumentoEntity.setId(id);
        return  tipoDocumentoRepository.save(tipoDocumentoEntity);
    }
    @Override
    public void remover(Long id) {
        log.info("removendo o tipo de documento de id {}", id);
       tipoDocumentoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        tipoDocumentoRepository.save((new TipoDocumentoEntity("RG")));
        tipoDocumentoRepository.save((new TipoDocumentoEntity("CPF")));
        tipoDocumentoRepository.save((new TipoDocumentoEntity("CNJP")));
    }
}
