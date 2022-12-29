package br.com.geradordedevs.gdrecursoshumanos.services;

import br.com.geradordedevs.gdrecursoshumanos.dtos.requests.ColaboradorRequestDTO;
import br.com.geradordedevs.gdrecursoshumanos.dtos.responses.ColaboradorResponseDTO;
import br.com.geradordedevs.gdrecursoshumanos.entities.ColaboradorEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface ColaboradorService {
    Iterable<ColaboradorEntity> findAll();
    ColaboradorEntity findById(Long id );
    ColaboradorEntity save( ColaboradorEntity entity);
    ColaboradorEntity updateById ( Long id,  ColaboradorEntity entity);
    void deleteById ( Long id);
    void popular();
}
