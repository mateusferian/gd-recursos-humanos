package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ColaboradorService {
    List<ColaboradorResponseDTO> listar();
    ColaboradorResponseDTO consultar(Long id );
    ColaboradorResponseDTO cadastrar( ColaboradorRequestDTO request);
    ColaboradorResponseDTO alterar ( Long id,  ColaboradorRequestDTO request);
    void remover ( Long id);
    void popular();
}
