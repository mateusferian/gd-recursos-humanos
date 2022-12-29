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
        log.info("listing positions");
        return cargoRepository.findAll();
    }

    @Override
    public CargoEntity findById(Long id) {
        log.info("getting job information {}", id);
        return cargoRepository.findById(id).orElseThrow(() -> new CargoException(CargoEnum.POSITION_NOT_FOUND));
    }

    @Override
    public CargoEntity save(CargoEntity entity){
        log.info("registering a new position {}", entity);
        return cargoRepository.save(entity);
    }

    @Override
    public CargoEntity updateById(Long id, CargoEntity entity) {
        log.info("changing the position of id {} with new information: {}", id, entity);
        findById(id);
        entity.setId(id);
        return cargoRepository.save(entity);
    }

    @Override
    public void deleteById(Long id) {
        log.info("removing the id charge {}", id);
        findById(id);
        cargoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        log.info("populating job database for testing");
        cargoRepository.save((new CargoEntity("administrador")));
        cargoRepository.save((new CargoEntity("vendedor")));
        cargoRepository.save((new CargoEntity("entregador")));
    }
}
