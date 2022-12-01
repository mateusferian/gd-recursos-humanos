package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CargoServiceImpl implements CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    @Override
    public Iterable<CargoEntity> listar() {
        return cargoRepository.findAll();
    }
    @Override
    public CargoEntity consultar(Long id) {
        return cargoRepository.findById(id).orElse(new CargoEntity());
    }
    public CargoEntity cadastrar(CargoEntity cargoEntity){
        return cargoRepository.save(cargoEntity);
    }
    @Override
    public CargoEntity alterar(Long id, CargoEntity cargoEntity) {
        cargoEntity.setId(id);
        return cargoRepository.save(cargoEntity);
    }
    @Override
    public void remover(Long id) {
        cargoRepository.deleteById(id);
    }
}
