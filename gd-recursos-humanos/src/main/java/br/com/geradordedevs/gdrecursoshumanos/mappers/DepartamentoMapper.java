package br.com.geradordedevs.gdrecursoshumanos.mappers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
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
public class DepartamentoMapper {

    @Autowired
    private final ModelMapper mapper;

    public DepartamentoResponseDTO toDto(DepartamentoEntity entity){
        log.info("converting entity{} to dto", entity);
        return  mapper.map(entity, DepartamentoResponseDTO.class);
    }

    public DepartamentoEntity toEntity(DepartamentoRequestDTO request){
        log.info("converting dto{} to entity", request);
        return  mapper.map(request, DepartamentoEntity.class);
    }

    public List<DepartamentoResponseDTO> toDtoList(Iterable<DepartamentoEntity> lista){
        log.info("converting entity list{} to dto list", lista);
        List<DepartamentoEntity> resultado = new ArrayList<>();
        lista.forEach(resultado::add);
        return  resultado.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
