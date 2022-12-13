package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        log.info("obtendo informações de cargo {}", id);
        return cargoRepository.findById(id).orElse(new CargoEntity());
    }
    public CargoEntity cadastrar(CargoEntity cargoEntity){
        log.info("cadastrando um novo cargo {}", cargoEntity);
        return cargoRepository.save(cargoEntity);
    }
    @Override
    public CargoEntity alterar(Long id, CargoEntity cargoEntity) {
        log.info("alterando o cargo de id {} com novas informações: {}", id, cargoEntity);
        cargoEntity.setId(id);
        return cargoRepository.save(cargoEntity);
    }
    @Override
    public void remover(Long id) {
        log.info("removendo o cargo de id {}", id);
        cargoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        cargoRepository.save((new CargoEntity("administrador")));
        cargoRepository.save((new CargoEntity("vendedor")));
        cargoRepository.save((new CargoEntity("entregador")));
    }
}
