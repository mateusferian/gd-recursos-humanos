package br.com.geradordedevs.gdrecursoshumanos.services.impl;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import br.com.geradordedevs.gdrecursoshumanos.mapper.DepartamentoMapper;
import br.com.geradordedevs.gdrecursoshumanos.repositories.DepartamentoRepository;
import br.com.geradordedevs.gdrecursoshumanos.services.DepartamentoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DepartamentoServiceImpl implements DepartamentoService {
    @Autowired
    private DepartamentoRepository departamentoRepository;
    @Autowired
    private DepartamentoMapper mapper;

    @Override
    public List<DepartamentoResponseDTO> listar() {
        log.info("listando departamentos");
        List<DepartamentoEntity> departamentoEntities = new ArrayList<>();
        for (DepartamentoEntity departamentoEntity: departamentoRepository.findAll()) {
         departamentoEntities.add(departamentoEntity);
        }
        return mapper.paraListaDto(departamentoEntities);
    }
    @Override
    public DepartamentoResponseDTO consultar(Long id) {
        log.info("obtendo informações de departamento {}", id);
        return  mapper.paraDto(departamentoRepository.findById(id).orElse(new DepartamentoEntity()));
    }
    @Override
    public DepartamentoResponseDTO cadastrar(DepartamentoRequestDTO request) {
        log.info("cadastrando um novo departamento {}", request);
        return mapper.paraDto(departamentoRepository.save(mapper.paraEntidade(request)));
    }
    @Override
    public DepartamentoResponseDTO alterar(Long id, DepartamentoRequestDTO request) {
        log.info("alterando o departamento de id {} com novas informações: {}", id, request);
        DepartamentoEntity departamento = mapper.paraEntidade(request);
        departamento.setId(id);
        return mapper.paraDto(departamentoRepository.save(departamento));
    }
    @Override
    public void remover(Long id) {
        log.info("removendo o departamento de id {}", id);
        departamentoRepository.deleteById(id);
    }

    @Override
    public void popular() {
        log.info("populando o banco de dados de Departamentos para teste");
        departamentoRepository.save((new DepartamentoEntity("adiministrativo")));
        departamentoRepository.save((new DepartamentoEntity("vendas")));
        departamentoRepository.save((new DepartamentoEntity("entregas")));
    }

}
