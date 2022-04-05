package erp.controle.estoque.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import erp.controle.estoque.model.domain.Casaco;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.repository.CasacoRepository;

@Service
public class CasacoService {
	
	@Autowired
	private CasacoRepository casacoRepository;

	public Collection<Casaco> obterLista(Usuario usuario) {
		return (Collection<Casaco>) casacoRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "marca")); 
	}		
	public Collection<Casaco> obterLista() {
		return (Collection<Casaco>) casacoRepository.findAll(Sort.by(Sort.Direction.ASC, "marca")); 
	}		
}