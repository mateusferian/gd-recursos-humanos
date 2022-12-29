package br.com.geradordedevs.gdrecursoshumanos.mappers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.CargoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.UsuarioRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.UsuarioResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
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
public class UsuarioMapper {

    @Autowired
    private final ModelMapper mapper;

    public UsuarioResponseDTO toDto(UsuarioEntity entity){
        log.info("convertendo entidade {} para dto", entity);
        return  mapper.map(entity, UsuarioResponseDTO.class);
    }

    public UsuarioEntity toEntity(UsuarioRequestDTO request){
        log.info("convertendo dto {} para entidade", request);
        return  mapper.map(request, UsuarioEntity.class);
    }

    public List<UsuarioResponseDTO> toDtoList(Iterable<UsuarioEntity> lista){
        log.info("convertendo lista de entidade {} para lista de dto", lista);
        List<UsuarioEntity> resultado = new ArrayList<>();
        lista.forEach(resultado::add);
        return  resultado.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
