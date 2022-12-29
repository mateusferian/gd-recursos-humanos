package br.com.geradordedevs.gdrecursoshumanos.mappers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.UsuarioEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.ColaboradorRepository;
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
public class AtestadoMapper {

    @Autowired
    private final ModelMapper mapper;

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    public AtestadoResponseDTO toDto(AtestadoEntity entity){
        log.info("convertendo entidade {} para dto", entity);
        return   mapper.map(entity, AtestadoResponseDTO.class);
    }

    public AtestadoEntity toEntity(AtestadoRequestDTO request){
        log.info("convertendo dto {} para entidade", request);

        AtestadoEntity atestadoEntity = mapper.map(request, AtestadoEntity.class);
        atestadoEntity.setColaborador(colaboradorRepository.findById(request.getColaborador()).orElse(new ColaboradorEntity()));

        return atestadoEntity;
    }

    public List<AtestadoResponseDTO> toDtoList(Iterable<AtestadoEntity> lista){
        log.info("convertendo lista de entidade {} para lista de dto", lista);
        List<AtestadoEntity> resultado = new ArrayList<>();
        lista.forEach(resultado::add);
        return  resultado.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
