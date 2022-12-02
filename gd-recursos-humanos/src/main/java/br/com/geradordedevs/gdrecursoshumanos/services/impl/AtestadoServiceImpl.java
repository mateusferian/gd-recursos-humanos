package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.AtestadoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.AtestadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

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
        log.info("obtendo informações de atestado {}", id);
        return atestadoRepository.findById(id).orElse(new AtestadoEntity());
    }
    @Override
    public AtestadoEntity cadastrar(AtestadoEntity atestadoEntity) {
        log.info("cadastrando um novo produto {}", atestadoEntity);
        return  atestadoRepository.save(atestadoEntity);
    }
    @Override
    public AtestadoEntity alterar(long id, AtestadoEntity atestadoEntity) {
        log.info("alterando o produto de id {} - novas informações: {}", id, atestadoEntity);
        atestadoEntity.setId(id);
        return atestadoRepository.save(atestadoEntity);
    }
    @Override
    public void remover(Long id) {
        log.info("removendo o atestado de id {}", id);
        atestadoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        cadastrar(new AtestadoEntity("COVID", new Date(2021-10-17),new ColaboradorEntity(1L)));
    }

}
