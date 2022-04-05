package erp.controle.estoque.model.repository;

import java.util.Collection;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import erp.controle.estoque.model.domain.Roupa;

@Repository
public interface RoupaRepository extends CrudRepository<Roupa, Integer> {

	@Query("from Roupa r where r.usuario.id = :idUsuario")
	Collection<Roupa> findAll(Integer idUsuario, Sort by);
	
	Collection<Roupa> findAll(Sort by);
}