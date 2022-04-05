package erp.controle.estoque.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import erp.controle.estoque.model.domain.Camisa;

@Repository
public interface CamisaRepository extends CrudRepository<Camisa, Integer> {

	@Query("from Camisa cs where cs.usuario.id = :idUsuario")
	Collection<Camisa> findAll(Integer idUsuario, Sort by);

	Collection<Camisa> findAll(Sort by);
}