package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.AtestadoException;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.AtestadoEnum;
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
    public Iterable<AtestadoEntity> findAll() {
        log.info("listing certificates");
        return atestadoRepository.findAll();
    }

    @Override
    public AtestadoEntity findById(Long id) {
        log.info("getting attestation information {}", id);
        return atestadoRepository.findById(id).orElseThrow(() -> new  AtestadoException(AtestadoEnum.CERTIFICATE_NOT_FOUND));
    }

    @Override
    public AtestadoEntity save(AtestadoEntity entity) {
        log.info("registering a new certificate {}", entity);
        return atestadoRepository.save(entity);
    }

    @Override
    public AtestadoEntity update(long id, AtestadoEntity entity) {
        log.info("changing the id {} attestation with new information: {}", id, entity);
        findById(id);
        entity.setId(id);
        return atestadoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        log.info("removing id attestation {}", id);
        findById(id);
        atestadoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        log.info("populating the attestation database for testing");
        atestadoRepository.save(new AtestadoEntity("COVID", new Date(121,10,17),new ColaboradorEntity(1L)));
    }
}
