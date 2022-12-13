package br.com.geradordedevs.gdrecursoshumanos.mapper;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.TipoDocumentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.TipoDocumentoResponseDTO;
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

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
@Slf4j
public class ColaboradorMapper {
    @Autowired
    private final ModelMapper mapper;
    @Autowired
    private CargoRepository cargoRepository;
    @Autowired
    private DepartamentoRepository departamentoRepository;
    @Autowired
    private TipoDocumentoRepository tipoDocumentoRepository;
    public ColaboradorResponseDTO paraDto(ColaboradorEntity entidade){
        log.info("convertendo entidade {} para Dto", entidade);
        ColaboradorResponseDTO colaboradorResponseDTO = new ColaboradorResponseDTO();
        colaboradorResponseDTO = mapper.map(entidade, ColaboradorResponseDTO.class);
        return colaboradorResponseDTO;
    }
    public ColaboradorEntity  paraEntidade(ColaboradorRequestDTO request){
        log.info("convertendo dto {} para entidade", request);
        ColaboradorEntity  colaboradorEntity = mapper.map(request, ColaboradorEntity.class);

        CargoEntity cargoEntity = cargoRepository.findById(request.getCargoId()).get();

        colaboradorEntity.setCargo(cargoEntity);

        DepartamentoEntity departamento = departamentoRepository.findById(request.getDepartamentoId()).get();

        colaboradorEntity.setDepartamento(departamento);

        TipoDocumentoEntity tipoDocumentoEntity = tipoDocumentoRepository.findById(request.getTipoDucumentoId()).get();

        colaboradorEntity.setTipoDucumento(tipoDocumentoEntity);

        return colaboradorEntity;
    }
    public List<ColaboradorResponseDTO> paraListaDto(List<ColaboradorEntity > lista){
        log.info("convertendo lista de entidade {} para lista de dto", lista);
        return  lista.stream()
                .map(this::paraDto)
                .collect(Collectors.toList());
    }
}
