package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.CargoEntity;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import br.com.geradordedevs.gdrecursoshumanos.mapper.AtestadoMapper;
import br.com.geradordedevs.gdrecursoshumanos.repositories.AtestadoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.AtestadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AtestadoServiceImpl implements AtestadoService {

    @Autowired
    public AtestadoRepository atestadoRepository;

    @Autowired
    public AtestadoMapper mapper;

    @Override
    public List<AtestadoResponseDTO> listar() {
        log.info("listando atestados");
        List<AtestadoEntity> atestadoEntities = new ArrayList<>();
        for (AtestadoEntity atestadoEntity: atestadoRepository.findAll()) {
            atestadoEntities.add(atestadoEntity);
        }
        return mapper.paraListaDto(atestadoEntities);
    }

    @Override
    public AtestadoResponseDTO consultar(Long id) {
        log.info("obtendo informacoes de atestado {}", id);
        return mapper.paraDto(atestadoRepository.findById(id).orElse(new AtestadoEntity()));
    }

    @Override
    public AtestadoResponseDTO cadastrar(AtestadoRequestDTO request) {
        log.info("cadastrando um novo atestado {}", request);
        return  mapper.paraDto(atestadoRepository.save(mapper.paraEntidade(request)));
    }

    @Override
    public AtestadoResponseDTO alterar(long id, AtestadoRequestDTO request) {
        log.info("alterando o atestado de id {} com novas informacoes: {}", id, request);
        AtestadoEntity atestado = mapper.paraEntidade(request);
        atestado.setId(id);
        return mapper.paraDto(atestadoRepository.save(atestado));
    }

    @Override
    public void remover(Long id) {
        log.info("removendo o atestado de id {}", id);
        atestadoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        log.info("populando o banco de dados de atestados para teste");
        atestadoRepository.save(new AtestadoEntity("COVID", new Date(121,10,17),new ColaboradorEntity(1L)));
    }
}
