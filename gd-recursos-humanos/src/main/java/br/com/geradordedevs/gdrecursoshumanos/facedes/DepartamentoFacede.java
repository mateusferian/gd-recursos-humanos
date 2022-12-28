package br.com.geradordedevs.gdrecursoshumanos.facedes;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.DepartamentoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.DepartamentoResponseDTO;

import java.util.List;

public interface DepartamentoFacede {
    List<DepartamentoResponseDTO> listar(String token);
    DepartamentoResponseDTO consultar(Long id,String token);
    DepartamentoResponseDTO cadastrar(DepartamentoRequestDTO request,String token);
    DepartamentoResponseDTO alterar(Long id, DepartamentoRequestDTO request,String token);
    void remover( Long id,String token);
    void popular(String token);
}
