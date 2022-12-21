package br.com.geradordedevs.gdrecursoshumanos.mappers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
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
public class TipoDocumentoMapper {

    @Autowired
    private final ModelMapper mapper;

    public TipoDocumentoResponseDTO paraDto(TipoDocumentoEntity entidade){
        log.info("convertendo entidade {} para dto", entidade);
        return  mapper.map(entidade, TipoDocumentoResponseDTO.class);
    }

    public TipoDocumentoEntity paraEntidade(TipoDocumentoRequestDTO request){
        log.info("convertendo dto {} para entidade", request);
        return  mapper.map(request, TipoDocumentoEntity.class);
    }

    public List<TipoDocumentoResponseDTO> paraListaDto(Iterable<TipoDocumentoEntity> lista){
        log.info("convertendo lista de entidade {} para lista de dto", lista);
        List<TipoDocumentoEntity> resultado = new ArrayList<>();
        lista.forEach(resultado::add);
        return  resultado.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }
}
