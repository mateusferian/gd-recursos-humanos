package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.ColaboradorRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import br.com.geradordedevs.gdrecursoshumanos.services.ColaboradorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class ColaboradorServiceImpl implements ColaboradorService {
    @Autowired
    private ColaboradorRepository colaboradorRepository;


    @Override
    public Iterable<ColaboradorEntity> listar() {
        log.info("listando colaboradores");
        return colaboradorRepository.findAll();
    }
    @Override
    public ColaboradorEntity consultar(Long id) {
        log.info("obtendo informações de colaborador {}", id);
        return  colaboradorRepository.findById(id).orElse(new ColaboradorEntity());
    }
    @Override
    public ColaboradorEntity cadastrar(ColaboradorEntity colaboradorEntity) {
        log.info("cadastrando um novo produto {}", colaboradorEntity);
        return colaboradorRepository.save(colaboradorEntity);
    }
    @Override
    public ColaboradorEntity alterar(Long id, ColaboradorEntity colaboradorEntity) {
        log.info("alterando o produto de id {} - novas informações: {}", id, colaboradorEntity);
        colaboradorEntity.setId(id);
        return colaboradorRepository.save(colaboradorEntity);
    }

    @Override
    public void remover(Long id) {
        log.info("removendo o colaborador de id {}", id);
        colaboradorRepository.deleteById(id);
    }

    @Override
    public void popular() {
        cadastrar(new ColaboradorEntity("jose",30,new Date(1923-11-22),new TipoDocumentoEntity(1L),"44.909.686-5",new CargoEntity(3L),new DepartamentoEntity(1L),4000,new Date(2017-13-10),true,"(11) 2152-1919","josepaulo@gmail.com"));
        cadastrar(new ColaboradorEntity("Maria",30,new Date(1921-12-21),new TipoDocumentoEntity(2L),"44.909.686-5",new CargoEntity(1L),new DepartamentoEntity(2L),2000,new Date(2018-12-10),true,"(11) 2133-1919","maria@gmail.com"));
        cadastrar(new ColaboradorEntity("Carlos",30,new Date(1922-10-15),new TipoDocumentoEntity(3L),"44.909.686-5",new CargoEntity(2L),new DepartamentoEntity(3L),1000,new Date(2019-11-10),true,"(11) 2153-1919","carlos@gmail.com"));
    }
}
