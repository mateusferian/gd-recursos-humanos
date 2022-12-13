package br.com.geradordedevs.gdrecursoshumanos.mapper;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CargoMapper {
    @Autowired
    private final ModelMapper mapper;
    public CargoResponseDTO paraDto(CargoEntity entidade){
        return  mapper.map(entidade, CargoResponseDTO.class);
    }
    public CargoEntity paraEntidade(CargoRequestDTO request){
        return  mapper.map(request, CargoEntity.class);

    }
    public List<CargoResponseDTO> paraListaDto(List<CargoEntity> lista){
        return  lista.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }
}
