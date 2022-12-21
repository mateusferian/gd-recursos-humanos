package br.com.geradordedevs.gdrecursoshumanos.mappers;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.repositories.CargoRepository;
import br.com.geradordedevs.gdrecursoshumanos.repositories.DepartamentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.repositories.TipoDocumentoRepository;
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
public class ColaboradorMapper {

    @Autowired
    private final ModelMapper mapper;

    @Autowired
    private DepartamentoRepository departamentoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;

    public ColaboradorResponseDTO paraDto(ColaboradorEntity entidade){
        log.info("convertendo entidade {} para dto", entidade);
        return  mapper.map(entidade, ColaboradorResponseDTO.class);
    }

    public ColaboradorEntity  paraEntidade(ColaboradorRequestDTO request){
        log.info("convertendo dto {} para entidade", request);

        ColaboradorEntity colaboradorEntity =mapper.map(request,ColaboradorEntity.class);
        colaboradorEntity.setDepartamento(departamentoRepository.findById(request.getDepartamento()).orElse(new DepartamentoEntity()));
        colaboradorEntity.setCargo(cargoRepository.findById(request.getCargo()).orElse(new CargoEntity()));
        colaboradorEntity.setTipoDocumento(tipoDocumentoRepository.findById(request.getTipoDocumento()).orElse(new TipoDocumentoEntity()));
        colaboradorEntity.setDepartamento(departamentoRepository.findById(request.getDepartamento()).orElse(new DepartamentoEntity()));

        return colaboradorEntity;
    }

    public List<ColaboradorResponseDTO> paraListaDto(Iterable<ColaboradorEntity > lista){
        log.info("convertendo lista de entidade {} para lista de dto", lista);
        List<ColaboradorEntity> resultado = new ArrayList<>();
        lista.forEach(resultado::add);
        return  resultado.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }
}
