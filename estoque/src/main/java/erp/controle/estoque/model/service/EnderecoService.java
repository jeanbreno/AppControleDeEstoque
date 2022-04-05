package erp.controle.estoque.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erp.controle.estoque.clients.IEnderecoClient;
import erp.controle.estoque.model.domain.Endereco;

@Service
public class EnderecoService {
	
	@Autowired
	private IEnderecoClient enderecoClient;

	public Endereco buscarCep(String cep) {
		
		return enderecoClient.buscarCep(cep);
	}
}