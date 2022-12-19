package br.com.geradordedevs.gdrecursoshumanos.repositories;

import br.com.geradordedevs.gdrecursoshumanos.entities.UsuarioEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
}
