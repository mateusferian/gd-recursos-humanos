package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.DepartamentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Iterable<DepartamentoEntity> listar() {
        log.info("listando departamentos");
        return departamentoRepository.findAll();
    }
    @Override
    public DepartamentoEntity consultar(Long id) {
        log.info("obtendo informações de departamento {}", id);
        return  departamentoRepository.findById(id).orElse(new DepartamentoEntity());
    }
    @Override
    public DepartamentoEntity cadastrar(DepartamentoEntity departamentoEntity) {
        log.info("cadastrando um novo departamento {}", departamentoEntity);
        return departamentoRepository.save(departamentoEntity);
    }
    @Override
    public DepartamentoEntity alterar(Long id, DepartamentoEntity departamentoEntity) {
        log.info("alterando o departamento de id {} com novas informações: {}", id, departamentoEntity);
        departamentoEntity.setId(id);
        return departamentoRepository.save(departamentoEntity);
    }
    @Override
    public void remover(Long id) {
        log.info("removendo o departamento de id {}", id);
        departamentoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        departamentoRepository.save((new DepartamentoEntity("adiministrativo")));
        departamentoRepository.save((new DepartamentoEntity("vendas")));
        departamentoRepository.save((new DepartamentoEntity("entregas")));
    }

}
