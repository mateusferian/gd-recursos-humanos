package br.com.geradordedevs.gdrecursoshumanos.facedes.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facedes.CargoFacede;
import br.com.geradordedevs.gdrecursoshumanos.mappers.CargoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CargoFacedeImpl implements CargoFacede {

    @Autowired
    private CargoMapper mapper;

    @Autowired
    private CargoService cargoService;

    @Override
    public List<CargoResponseDTO> listar() {
        return mapper.paraListaDto(cargoService.listar());
    }

    @Override
    public CargoResponseDTO consultar(Long id) {
        return mapper.paraDto(cargoService.consultar(id));
    }

    @Override
    public CargoResponseDTO cadastrar(CargoRequestDTO request) {
        return mapper.paraDto(cargoService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public CargoResponseDTO alterar(Long id, CargoRequestDTO request) {
        return mapper.paraDto(cargoService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id) {
        cargoService.remover(id);
    }

    @Override
    public void popular() {
        cargoService.popular();
    }
}
