package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.TipoDocumentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.TipoDocumentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TipoDucmentoServiceImpl implements TipoDocumentoService {
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    @Override
    public Iterable<TipoDocumentoEntity> listar() {
        return tipoDocumentoRepository.findAll();
    }
    @Override
    public TipoDocumentoEntity consultar(Long id) {
        return tipoDocumentoRepository.findById(id).orElse(new TipoDocumentoEntity());
    }
    @Override
    public TipoDocumentoEntity cadastrar(TipoDocumentoEntity tipoDocumentoEntity) {
        return  tipoDocumentoRepository.save(tipoDocumentoEntity);
    }
    @Override
    public TipoDocumentoEntity alterar(Long id, TipoDocumentoEntity tipoDocumentoEntity) {
        tipoDocumentoEntity.setId(id);
        return  tipoDocumentoRepository.save(tipoDocumentoEntity);
    }
    @Override
    public void remover(Long id) {
       tipoDocumentoRepository.deleteById(id);
    }
}
