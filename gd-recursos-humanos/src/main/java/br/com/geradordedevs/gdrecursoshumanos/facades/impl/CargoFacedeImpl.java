package br.com.geradordedevs.gdrecursoshumanos.facades.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facades.CargoFacade;
import br.com.geradordedevs.gdrecursoshumanos.mappers.CargoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CargoFacedeImpl implements CargoFacade {

    @Autowired
    private CargoMapper mapper;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private TokenService tokenService;


    @Override
    public List<CargoResponseDTO> findAll(String token) {
        tokenService.validate(token);
        return mapper.toDtoList(cargoService.findAll());
    }

    @Override
    public CargoResponseDTO findById(Long id,String token) {
        tokenService.validate(token);
        return mapper.toDto(cargoService.findById(id));
    }

    @Override
    public CargoResponseDTO save(CargoRequestDTO request,String token) {
        tokenService.validate(token);
        return mapper.toDto(cargoService.save(mapper.toEntity(request)));
    }

    @Override
    public CargoResponseDTO update(Long id, CargoRequestDTO request,String token) {
        tokenService.validate(token);
        return mapper.toDto(cargoService.update(id,mapper.toEntity(request)));
    }

    @Override
    public void deleteById(Long id,String token) {
        tokenService.validate(token);
        cargoService.deleteById(id);
    }

    @Override
    public void populating(String token) {
        tokenService.validate(token);
        cargoService.populating();
    }
}
