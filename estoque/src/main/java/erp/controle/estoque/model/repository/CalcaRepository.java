package erp.controle.estoque.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import erp.controle.estoque.model.domain.Calca;

@Repository
public interface CalcaRepository extends CrudRepository<Calca, Integer> {

	@Query("from Calca c where c.usuario.id = :idUsuario")
	Collection<Calca> findAll(Integer idUsuario, Sort by);
	
	Collection<Calca> findAll(Sort by);
}