package br.com.geradordedevs.gdrecursoshumanos.mapper;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
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
public class DepartamentoMapper {

    @Autowired
    private final ModelMapper mapper;

    public DepartamentoResponseDTO paraDto(DepartamentoEntity entidade){
        log.info("convertendo entidade {} para dto", entidade);
        return  mapper.map(entidade, DepartamentoResponseDTO.class);
    }

    public DepartamentoEntity paraEntidade(DepartamentoRequestDTO request){
        log.info("convertendo dto {} para entidade", request);
        return  mapper.map(request, DepartamentoEntity.class);
    }

    public List<DepartamentoResponseDTO> paraListaDto(List<DepartamentoEntity> lista){
        log.info("convertendo lista de entidade {} para lista de dto", lista);
        return  lista.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }
}
