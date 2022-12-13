package br.com.geradordedevs.gdrecursoshumanos.mapper;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ColaboradorMapper {
    @Autowired
    private final ModelMapper mapper;
    public ColaboradorResponseDTO paraDto(ColaboradorEntity entidade){
        return  mapper.map(entidade, ColaboradorResponseDTO.class);
    }
    public ColaboradorEntity  paraEntidade(ColaboradorRequestDTO request){
        return  mapper.map(request, ColaboradorEntity .class);

    }
    public List<ColaboradorResponseDTO> paraListaDto(List<ColaboradorEntity > lista){
        return  lista.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }
}
