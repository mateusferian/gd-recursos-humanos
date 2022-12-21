package br.com.geradordedevs.gdrecursoshumanos.mappers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.UsuarioEntity;
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

    public AtestadoResponseDTO paraDto(AtestadoEntity entidade){
        log.info("convertendo entidade {} para dto", entidade);
        return   mapper.map(entidade, AtestadoResponseDTO.class);
    }

    public AtestadoEntity paraEntidade(AtestadoRequestDTO request){
        log.info("convertendo dto {} para entidade", request);
        return mapper.map(request, AtestadoEntity.class);
    }

    public List<AtestadoResponseDTO> paraListaDto(Iterable<AtestadoEntity> lista){
        log.info("convertendo lista de entidade {} para lista de dto", lista);
        List<AtestadoEntity> resultado = new ArrayList<>();
        lista.forEach(resultado::add);
        return  resultado.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }
}
