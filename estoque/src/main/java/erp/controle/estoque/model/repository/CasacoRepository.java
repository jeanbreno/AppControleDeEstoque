package erp.controle.estoque.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import erp.controle.estoque.model.domain.Casaco;

@Repository
public interface CasacoRepository extends CrudRepository<Casaco, Integer> {

	@Query("from Casaco c where c.usuario.id = :idUsuario")
	Collection<Casaco> findAll(Integer idUsuario, Sort by);
	
	Collection<Casaco> findAll(Sort by);
}