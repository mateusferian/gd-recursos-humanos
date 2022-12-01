package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.ColaboradorRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ColaboradorServiceImpl implements ColaboradorService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Override
    public Iterable<ColaboradorEntity> listar() {
        return colaboradorRepository.findAll();
    }
    @Override
    public ColaboradorEntity consultar(Long id) {
        return  colaboradorRepository.findById(id).orElse(new ColaboradorEntity());
    }
    @Override
    public ColaboradorEntity cadastrar(ColaboradorEntity colaboradorEntity) {
        return colaboradorRepository.save(colaboradorEntity);
    }
    @Override
    public ColaboradorEntity alterar(Long id, ColaboradorEntity colaboradorEntity) {
        colaboradorEntity.setId(id);
        return colaboradorRepository.save(colaboradorEntity);
    }

    @Override
    public void remover(Long id) {
        colaboradorRepository.deleteById(id);
    }
}
