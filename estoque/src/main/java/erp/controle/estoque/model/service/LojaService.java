package erp.controle.estoque.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import erp.controle.estoque.model.domain.Loja;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.repository.LojaRepository;

@Service
public class LojaService {
	
	@Autowired
	private LojaRepository lojaRepository;

	public Collection<Loja> obterLista(Usuario usuario){
		return (Collection<Loja>) lojaRepository.obterLista(usuario.getId(), Sort.by(Sort.Direction.ASC, "nome"));
	}

	public Collection<Loja> obterLista(){
		return (Collection<Loja>) lojaRepository.findAll();
	}
	
	public Loja incluir(Loja loja){
		return lojaRepository.save(loja);
	}
	
	public void excluir(Integer id) {
		lojaRepository.deleteById(id);
	}
	
	public Loja obterPorId(Integer id) {
		return lojaRepository.findById(id).orElse(null);
	}

	public Integer obterQtde(){
		return (int) lojaRepository.count();
	}
}