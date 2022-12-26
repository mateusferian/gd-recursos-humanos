package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.mappers.CargoMapper;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class CargoServiceImpl implements CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Iterable<CargoEntity> listar() {
        log.info("listando cargos");
        return cargoRepository.findAll();
    }

    @Override
    public CargoEntity consultar(Long id) {
        log.info("obtendo informacoes de cargo {}", id);
        return cargoRepository.findById(id).orElse(new CargoEntity());
    }

    @Override
    public CargoEntity cadastrar(CargoEntity entity){
        log.info("cadastrando um novo cargo {}", entity);
        return cargoRepository.save(entity);
    }

    @Override
    public CargoEntity alterar(Long id, CargoEntity entity) {
        log.info("alterando o cargo de id {} com novas informacoes: {}", id, entity);
        entity.setId(id);
        return cargoRepository.save(entity);
    }

    @Override
    public void remover(Long id) {
        log.info("removendo o cargo de id {}", id);
        cargoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        log.info("populando o banco de dados de cargos para teste");
        cargoRepository.save((new CargoEntity("administrador")));
        cargoRepository.save((new CargoEntity("vendedor")));
        cargoRepository.save((new CargoEntity("entregador")));
    }
}
