package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

public interface DepartamentoService {
    Iterable<DepartamentoEntity> listar();
    DepartamentoEntity consultar(Long id);
    DepartamentoEntity cadastrar(DepartamentoEntity entity);
    DepartamentoEntity alterar(Long id, DepartamentoEntity entity);
    void remover( Long id);
    void popular();
}
