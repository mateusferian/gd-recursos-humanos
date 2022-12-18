package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.mapper.CargoMapper;
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
    @Autowired
    private CargoMapper mapper;
    @Override
    public List<CargoResponseDTO> listar() {
        log.info("listando cargos");
        List<CargoEntity> cargoEntities = new ArrayList<>();
        for (CargoEntity cargoEntity: cargoRepository.findAll()) {
            cargoEntities.add(cargoEntity);
        }
        return mapper.paraListaDto(cargoEntities);
    }
    @Override
    public CargoResponseDTO consultar(Long id) {
        log.info("obtendo informacoes de cargo {}", id);
        return mapper.paraDto(cargoRepository.findById(id).orElse(new CargoEntity()));
    }
    @Override
    public CargoResponseDTO cadastrar(CargoRequestDTO request){
        log.info("cadastrando um novo cargo {}", request);
        return mapper.paraDto(cargoRepository.save(mapper.paraEntidade(request)));
    }
    @Override
    public CargoResponseDTO alterar(Long id, CargoRequestDTO request) {
        log.info("alterando o cargo de id {} com novas informacoes: {}", id, request);
        CargoEntity cargo = mapper.paraEntidade(request);
        cargo.setId(id);
        return mapper.paraDto(cargoRepository.save(cargo));
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
