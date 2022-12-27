package br.com.geradordedevs.gdrecursoshumanos.facedes.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.facedes.CargoFacede;
import br.com.geradordedevs.gdrecursoshumanos.mappers.CargoMapper;
import br.com.geradordedevs.gdrecursoshumanos.services.CargoService;
import br.com.geradordedevs.gdrecursoshumanos.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class CargoFacedeImpl implements CargoFacede {

    @Autowired
    private CargoMapper mapper;

    @Autowired
    private CargoService cargoService;

    @Autowired
    private TokenService tokenService;


    @Override
    public List<CargoResponseDTO> listar(String token) {
        tokenService.validar(token);
        return mapper.paraListaDto(cargoService.listar());
    }

    @Override
    public CargoResponseDTO consultar(Long id,String token) {
        tokenService.validar(token);
        return mapper.paraDto(cargoService.consultar(id));
    }

    @Override
    public CargoResponseDTO cadastrar(CargoRequestDTO request,String token) {
        tokenService.validar(token);
        return mapper.paraDto(cargoService.cadastrar(mapper.paraEntidade(request)));
    }

    @Override
    public CargoResponseDTO alterar(Long id, CargoRequestDTO request,String token) {
        tokenService.validar(token);
        return mapper.paraDto(cargoService.alterar(id,mapper.paraEntidade(request)));
    }

    @Override
    public void remover(Long id,String token) {
        tokenService.validar(token);
        cargoService.remover(id);
    }

    @Override
    public void popular(String token) {
        tokenService.validar(token);
        cargoService.popular();
    }
}
