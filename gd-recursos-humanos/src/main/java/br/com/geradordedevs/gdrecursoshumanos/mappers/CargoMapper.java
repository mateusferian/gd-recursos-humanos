package br.com.geradordedevs.gdrecursoshumanos.mappers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.CargoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class CargoMapper {

    @Autowired
    private final ModelMapper mapper;

    public CargoResponseDTO paraDto(CargoEntity entidade){
        log.info("convertendo entidade {} para dto", entidade);
        return  mapper.map(entidade, CargoResponseDTO.class);
    }

    public CargoEntity paraEntidade(CargoRequestDTO request){
        log.info("convertendo dto {} para entidade", request);
        return  mapper.map(request, CargoEntity.class);
    }

    public List<CargoResponseDTO> paraListaDto(List<CargoEntity> lista){
        log.info("convertendo lista de entidade {} para lista de dto", lista);
        return  lista.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }
}