package br.com.geradordedevs.gdrecursoshumanos.mappers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class CargoMapper {

    @Autowired
    private final ModelMapper mapper;

    public CargoResponseDTO toDto(CargoEntity entity){
        log.info("converting entity{} to dto", entity);
        return  mapper.map(entity, CargoResponseDTO.class);
    }

    public CargoEntity toEntity(CargoRequestDTO request){
        log.info("converting dto{} to entity", request);
        return  mapper.map(request, CargoEntity.class);
    }

    public List<CargoResponseDTO> toDtoList(Iterable<CargoEntity> lista){
        log.info("converting entity list{} to dto list", lista);
        List<CargoEntity> resultado = new ArrayList<>();
        lista.forEach(resultado::add);
        return  resultado.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
