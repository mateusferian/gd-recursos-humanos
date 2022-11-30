package br.com.geradordedevs.gdrecursoshumanos.repositories;

import br.com.geradordedevs.gdrecursoshumanos.entities.DepartamentoEntity;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentoRepository extends CrudRepository<DepartamentoEntity,Long> {
}
