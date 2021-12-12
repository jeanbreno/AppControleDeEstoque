package erp.controle.estoque.model.domain;

import erp.controle.estoque.exceptions.CnpjInvalidoException;
import erp.controle.estoque.exceptions.ContatoInvalidoException;
import erp.controle.estoque.exceptions.NomeInvalidoException;

public class Loja {
	
	private String nome;
	private String contato;
	private String cnpj;
	
	String delimitador = ";";
	
	public Loja(String nome, String contato, String cnpj) throws NomeInvalidoException, ContatoInvalidoException, CnpjInvalidoException {
		
		if(nome == null) {
			throw new NomeInvalidoException("Não é possível seguir com o campo Nome nulo.");
		}
		if(contato == null) {
			throw new ContatoInvalidoException("Não é possível seguir com o campo Contato nulo.");
		}
		if(cnpj == null) {
			throw new CnpjInvalidoException("Não é possível seguir com o campo CNPJ nulo.");
		}
		
		this.nome = nome;
		this.contato = contato;
		this.cnpj = cnpj;
	}

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(nome);
		sb.append(delimitador);
		sb.append(contato);
		sb.append(delimitador);
		sb.append(cnpj);
		
		return sb.toString();
	}
	
	public String getNome() {
		return nome;
	}
	public String getContato() {
		return contato;
	}
	public String getCnpj() {
		return cnpj;
	}
}


