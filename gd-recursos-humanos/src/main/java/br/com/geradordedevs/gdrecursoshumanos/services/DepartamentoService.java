package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.List;
import java.util.Optional;

public interface DepartamentoService {
    List<DepartamentoResponseDTO> listar();
    DepartamentoResponseDTO consultar(Long id);
    DepartamentoResponseDTO cadastrar(DepartamentoRequestDTO request);
    DepartamentoResponseDTO alterar(Long id, DepartamentoRequestDTO request);
    void remover(@PathVariable Long id);
     void popular();
}
