package br.com.geradordedevs.gdrecursoshumanos.mappers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
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
public class ColaboradorMapper {

    @Autowired
    private final ModelMapper mapper;

    public ColaboradorResponseDTO paraDto(ColaboradorEntity entidade){
        log.info("convertendo entidade {} para dto", entidade);
        return  mapper.map(entidade, ColaboradorResponseDTO.class);
    }

    public ColaboradorEntity  paraEntidade(ColaboradorRequestDTO request){
        log.info("convertendo dto {} para entidade", request);
        return  mapper.map(request, ColaboradorEntity.class);
    }

    public List<ColaboradorResponseDTO> paraListaDto(List<ColaboradorEntity > lista){
        log.info("convertendo lista de entidade {} para lista de dto", lista);
        return  lista.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }
}
