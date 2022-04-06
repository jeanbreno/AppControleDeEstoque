package erp.controle.estoque.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import erp.controle.estoque.model.domain.Roupa;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.repository.RoupaRepository;

@Service
public class RoupaService{
	
	@Autowired
	private RoupaRepository roupaRepository;
	//public Roupa roupa;
	
	public Collection<Roupa> obterLista(Usuario usuario) {
		return (Collection<Roupa>) roupaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome")); 
	}	

	public Collection<Roupa> obterLista() {
		return (Collection<Roupa>) roupaRepository.findAll(Sort.by(Sort.Direction.ASC, "descricao")); 
	}	

	public Integer obterQtde(){
		return (int) roupaRepository.count();
	}
	
	public void incluir(Roupa roupa){
		roupaRepository.save(roupa);
		}
	
	public void excluir(Integer id) { 
		roupaRepository.deleteById(id); 
		}
 
	public Roupa obterPorId(Integer id) { 
		return roupaRepository.findById(id).orElse(null); 
		} 
}
 