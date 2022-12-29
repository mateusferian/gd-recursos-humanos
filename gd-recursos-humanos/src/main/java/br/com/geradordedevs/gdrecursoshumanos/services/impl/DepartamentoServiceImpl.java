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
        log.info("listando departamentos");
        return departamentoRepository.findAll();
    }

    @Override
    public DepartamentoEntity findById(Long id) {
        log.info("obtendo informacoes de departamento {}", id);
        return  departamentoRepository.findById(id).orElseThrow(() -> new DepartamentoException(DepartamentoEnum.DEPARTAMENTO_NAO_ENCONTRADO));
    }

    @Override
    public DepartamentoEntity save(DepartamentoEntity entity) {
        log.info("cadastrando um novo departamento {}", entity);
        return departamentoRepository.save(entity);
    }

    @Override
    public DepartamentoEntity updateById(Long id, DepartamentoEntity entity) {
        log.info("alterando o departamento de id {} com novas informacoes: {}", id, entity);
        findById(id);
        entity.setId(id);
        return departamentoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        log.info("removendo o departamento de id {}", id);
        findById(id);
        departamentoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        log.info("populando o banco de dados de departamentos para teste");
        departamentoRepository.save((new DepartamentoEntity("adiministrativo")));
        departamentoRepository.save((new DepartamentoEntity("vendas")));
        departamentoRepository.save((new DepartamentoEntity("entregas")));
    }
}
