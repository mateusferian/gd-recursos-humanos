package br.com.geradordedevs.gdrecursoshumanos.facades;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;

import java.util.List;

public interface DepartamentoFacade {
    List<DepartamentoResponseDTO> findAll(String token);
    DepartamentoResponseDTO findById(Long id,String token);
    DepartamentoResponseDTO save(DepartamentoRequestDTO request,String token);
    DepartamentoResponseDTO update(Long id, DepartamentoRequestDTO request,String token);
    void deleteById( Long id,String token);
    void populating(String token);
}
