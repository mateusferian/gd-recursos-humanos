package br.com.geradordedevs.gdrecursoshumanos.facedes;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;

import java.util.List;

public interface DepartamentoFacede {
    List<DepartamentoResponseDTO> listar();
    DepartamentoResponseDTO consultar(Long id);
    DepartamentoResponseDTO cadastrar(DepartamentoRequestDTO request);
    DepartamentoResponseDTO alterar(Long id, DepartamentoRequestDTO request);
    void remover( Long id);
    void popular();
}
