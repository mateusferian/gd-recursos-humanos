package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.TipoDocumentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.mappers.ColaboradorMapper;
import br.com.geradordedevs.gdrecursoshumanos.repositories.ColaboradorRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.ColaboradorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ColaboradorServiceImpl implements ColaboradorService {

    @Autowired
    private ColaboradorRepository colaboradorRepository;

    @Autowired
    private ColaboradorMapper mapper;

    @Override
    public List<ColaboradorResponseDTO> listar() {
        log.info("listando colaboradores");
        List<ColaboradorEntity> colaboradorEntities = new ArrayList<>();
        for (ColaboradorEntity colaboradorEntity: colaboradorRepository.findAll()) {
            colaboradorEntities.add(colaboradorEntity);
        }
        return mapper.paraListaDto(colaboradorEntities);
    }

    @Override
    public ColaboradorResponseDTO consultar(Long id) {
        log.info("obtendo informacoes de colaborador {}", id);
        return  mapper.paraDto(colaboradorRepository.findById(id).orElse(new ColaboradorEntity()));
    }

    @Override
    public ColaboradorResponseDTO cadastrar(ColaboradorRequestDTO request) {
        log.info("cadastrando um novo colaborador {}", request);
        return mapper.paraDto(colaboradorRepository.save(mapper.paraEntidade(request)));
    }

    @Override
    public ColaboradorResponseDTO alterar(Long id, ColaboradorRequestDTO request) {
        log.info("alterando o colaborador de id {} com novas informacoes: {}", id, request);
        ColaboradorEntity colaborador = mapper.paraEntidade(request);
        colaborador.setId(id);
        return mapper.paraDto(colaboradorRepository.save(colaborador));
    }

    @Override
    public void remover(Long id) {
        log.info("removendo o colaborador de id {}", id);
        colaboradorRepository.deleteById(id);
    }

    @Override
    public void popular() {
        log.info("populando o banco de dados de colaboradores para teste");
        colaboradorRepository.save(new ColaboradorEntity("jose",29,new Date(93,11,22),new TipoDocumentoEntity(1L),"44.909.686-5",new CargoEntity(1L),new DepartamentoEntity(1L),4000,new Date(117,10,10),true,"(11) 2152-1919","josepaulo@gmail.com"));
        colaboradorRepository.save(new ColaboradorEntity("Maria",31,new Date(91,9,21),new TipoDocumentoEntity(2L),"145.201.330-68",new CargoEntity(2L),new DepartamentoEntity(2L),2000,new Date(118,11,10),true,"(11) 2133-1919","maria@gmail.com"));
        colaboradorRepository.save(new ColaboradorEntity("Carlos",30,new Date(92,10,15),new TipoDocumentoEntity(3L),"00.886.436/0001-20",new CargoEntity(3L),new DepartamentoEntity(3L),1000,new Date(119,11,10),true,"(11) 2154-1919","carlos@gmail.com"));
    }
}
