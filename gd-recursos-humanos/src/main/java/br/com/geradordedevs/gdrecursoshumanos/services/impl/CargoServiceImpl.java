package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.CargoException;
import br.com.geradordedevs.gdrecursoshumanos.exceptions.enums.CargoEnum;
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
    public Iterable<CargoEntity> findAll() {
        log.info("listando cargos");
        return cargoRepository.findAll();
    }

    @Override
    public CargoEntity findById(Long id) {
        log.info("obtendo informacoes de cargo {}", id);
        return cargoRepository.findById(id).orElseThrow(() -> new CargoException(CargoEnum.CARGO_NAO_ENCONTRADO));
    }

    @Override
    public CargoEntity save(CargoEntity entity){
        log.info("cadastrando um novo cargo {}", entity);
        return cargoRepository.save(entity);
    }

    @Override
    public CargoEntity updateById(Long id, CargoEntity entity) {
        log.info("alterando o cargo de id {} com novas informacoes: {}", id, entity);
        findById(id);
        entity.setId(id);
        return cargoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        log.info("removendo o cargo de id {}", id);
        findById(id);
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
