package erp.controle.estoque.model.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import erp.controle.estoque.model.domain.Calca;
import erp.controle.estoque.model.domain.Usuario;
import erp.controle.estoque.model.repository.CalcaRepository;

@Service
public class CalcaService {
	
	@Autowired
	private CalcaRepository calcaRepository;

	public Collection<Calca> obterLista(Usuario usuario) {
		return (Collection<Calca>) calcaRepository.findAll(usuario.getId(), Sort.by(Sort.Direction.ASC, "marca")); 
	}		
	public Collection<Calca> obterLista() {
		return (Collection<Calca>) calcaRepository.findAll(Sort.by(Sort.Direction.ASC, "marca")); 
	}		
}