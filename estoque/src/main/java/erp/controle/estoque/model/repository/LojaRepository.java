package erp.controle.estoque.model.repository;

import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import erp.controle.estoque.model.domain.Loja;

@Repository
public interface LojaRepository extends CrudRepository<Loja, Integer> {

	@Query("from Loja j where j.usuario.id = :idUsuario")
	public List<Loja> obterLista(Integer idUsuario, Sort sort);
	
}