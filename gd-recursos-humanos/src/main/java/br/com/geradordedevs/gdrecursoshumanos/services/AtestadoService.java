package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.AtestadoRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.AtestadoResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.AtestadoEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface AtestadoService {
    Iterable<AtestadoEntity> findAll();
    AtestadoEntity findById(Long id );
    AtestadoEntity save(AtestadoEntity entity);
    AtestadoEntity update ( long id,  AtestadoEntity entity);
    void deleteById ( Long id);
    void popular();
}
