package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AtestadoService {
    List<AtestadoResponseDTO> listar();
    AtestadoResponseDTO consultar(Long id );
    AtestadoResponseDTO cadastrar(AtestadoRequestDTO request);
    AtestadoResponseDTO alterar ( long id,  AtestadoRequestDTO request);
    void remover ( Long id);
    void popular();
}
