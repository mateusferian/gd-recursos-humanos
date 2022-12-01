package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.DepartamentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Iterable<DepartamentoEntity> listar() {
        return departamentoRepository.findAll();
    }
    @Override
    public DepartamentoEntity consultar(Long id) {
        return  departamentoRepository.findById(id).orElse(new DepartamentoEntity());
    }
    @Override
    public DepartamentoEntity cadastrar(DepartamentoEntity departamentoEntity) {
        return departamentoRepository.save(departamentoEntity);
    }
    @Override
    public DepartamentoEntity alterar(Long id, DepartamentoEntity departamentoEntity) {
        departamentoEntity.setId(id);
        return departamentoRepository.save(departamentoEntity);
    }
    @Override
    public void remover(Long id) {
        departamentoRepository.deleteById(id);
    }

}
