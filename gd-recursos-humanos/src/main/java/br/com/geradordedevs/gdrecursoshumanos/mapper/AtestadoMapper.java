package br.com.geradordedevs.gdrecursoshumanos.mapper;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.ColaboradorRepository;
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
public class AtestadoMapper {
    @Autowired
    private final ModelMapper mapper;
    @Autowired
    private ColaboradorRepository colaboradorRepository;
    public AtestadoResponseDTO paraDto(AtestadoEntity entidade){
        log.info("convertendo entidade {} para Dto", entidade);
        AtestadoResponseDTO atestadoResponseDTO = new AtestadoResponseDTO();
        atestadoResponseDTO = mapper.map(entidade, AtestadoResponseDTO.class);
        return  atestadoResponseDTO;
    }
    public AtestadoEntity paraEntidade(AtestadoRequestDTO request){
        log.info("convertendo dto {} para entidade", request);
        AtestadoEntity atestadoEntity =  mapper.map(request, AtestadoEntity.class);
        ColaboradorEntity colaboradorEntity = colaboradorRepository.findById(request.getColaboradorId()).get();
        atestadoEntity.setColaborador(colaboradorEntity);
        return atestadoEntity;

    }
    public List<AtestadoResponseDTO> paraListaDto(List<AtestadoEntity> lista){
        log.info("convertendo lista de entidade {} para lista de dto", lista);
        return  lista.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }

}
