package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.AtestadoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.AtestadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AtestadoServiceImpl implements AtestadoService {
    @Autowired
    public AtestadoRepository atestadoRepository;

    @Override
    public Iterable<AtestadoEntity> listar() {
        return atestadoRepository.findAll();
    }
    @Override
    public AtestadoEntity consultar(Long id) {
        return atestadoRepository.findById(id).orElse(new AtestadoEntity());
    }
    @Override
    public AtestadoEntity cadastrar(AtestadoEntity atestadoEntity) {
        return  atestadoRepository.save(atestadoEntity);
    }
    @Override
    public AtestadoEntity alterar(long id, AtestadoEntity atestadoEntity) {
        atestadoEntity.setId(id);
        return atestadoRepository.save(atestadoEntity);
    }
    @Override
    public void remover(Long id) {
        atestadoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        cadastrar(new AtestadoEntity("COVID", new Date(2021-10-17),new ColaboradorEntity(1L)));
    }

}
