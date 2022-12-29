package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.DepartamentoException;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.DepartamentoEnum;
import br.com.geradordedevs.gdrecursoshumanos.mappers.DepartamentoMapper;
import br.com.geradordedevs.gdrecursoshumanos.repositories.DepartamentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Override
    public Iterable<DepartamentoEntity> findAll() {
        log.info("listing departments");
        return departamentoRepository.findAll();
    }

    @Override
    public DepartamentoEntity findById(Long id) {
        log.info("getting department information {}", id);
        return  departamentoRepository.findById(id).orElseThrow(() -> new DepartamentoException(DepartamentoEnum.DEPARTMENT_NOT_FOUND));
    }

    @Override
    public DepartamentoEntity save(DepartamentoEntity entity) {
        log.info("registering a new department {}", entity);
        return departamentoRepository.save(entity);
    }

    @Override
    public DepartamentoEntity update(Long id, DepartamentoEntity entity) {
        log.info("changing the id department {} with new information: {}", id, entity);
        findById(id);
        entity.setId(id);
        return departamentoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        log.info("removing the id department {}", id);
        findById(id);
        departamentoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        log.info("populating the departments database for testing");
        departamentoRepository.save((new DepartamentoEntity("adiministrativo")));
        departamentoRepository.save((new DepartamentoEntity("vendas")));
        departamentoRepository.save((new DepartamentoEntity("entregas")));
    }
}
