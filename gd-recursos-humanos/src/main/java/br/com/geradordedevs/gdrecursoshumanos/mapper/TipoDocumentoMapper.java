package br.com.geradordedevs.gdrecursoshumanos.mapper;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TipoDocumentoMapper {
    @Autowired
    private final ModelMapper mapper;
    public TipoDocumentoResponseDTO paraDto(TipoDocumentoEntity entidade){
        return  mapper.map(entidade, TipoDocumentoResponseDTO.class);
    }
    public TipoDocumentoEntity paraEntidade(TipoDocumentoRequestDTO request){
        return  mapper.map(request, TipoDocumentoEntity.class);

    }
    public List<TipoDocumentoResponseDTO> paraListaDto(List<TipoDocumentoEntity> lista){
        return  lista.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }
}
