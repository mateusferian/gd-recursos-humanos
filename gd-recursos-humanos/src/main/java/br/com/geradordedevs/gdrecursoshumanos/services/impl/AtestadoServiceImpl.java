package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.mappers.AtestadoMapper;
import br.com.geradordedevs.gdrecursoshumanos.repositories.AtestadoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.AtestadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AtestadoServiceImpl implements AtestadoService {

    @Autowired
    public AtestadoRepository atestadoRepository;

    @Override
    public Iterable<AtestadoEntity> listar() {
        log.info("listando atestados");
        return atestadoRepository.findAll();
    }

    @Override
    public AtestadoEntity consultar(Long id) {
        log.info("obtendo informacoes de atestado {}", id);
        return atestadoRepository.findById(id).orElse(new AtestadoEntity());
    }

    @Override
    public AtestadoEntity cadastrar(AtestadoEntity entity) {
        log.info("cadastrando um novo atestado {}", entity);
        return atestadoRepository.save(entity);
    }

    @Override
    public AtestadoEntity alterar(long id, AtestadoEntity entity) {
        log.info("alterando o atestado de id {} com novas informacoes: {}", id, entity);
        entity.setId(id);
        return atestadoRepository.save(entity);
    }

    @Override
    public void remover(Long id) {
        log.info("removendo o atestado de id {}", id);
        atestadoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        log.info("populando o banco de dados de atestados para teste");
        atestadoRepository.save(new AtestadoEntity("COVID", new Date(121,10,17),new ColaboradorEntity(1L)));
    }
}
