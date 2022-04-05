package erp.controle.estoque.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import erp.controle.estoque.model.domain.Camisa;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.repository.CamisaRepository;

@Service
public class CamisaService {
	
	@Autowired
	private CamisaRepository camisaRepository;

	public Collection<Camisa> obterLista(Usuario usuario) {
		return (Collection<Camisa>) camisaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "marca")); 
	}		
	public Collection<Camisa> obterLista() {
		return (Collection<Camisa>) camisaRepository.findAll(Sort.by(Sort.Direction.ASC, "marca")); 
	}		
}