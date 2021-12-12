package erp.controle.estoque.model.domain;

public class Loja {
	
	private String nome;
	private String contato;
	private String cnpj;
	
	public Loja(String nome, String contato, String cnpj) {
		this.nome = nome;
		this.contato = contato;
		this.cnpj = cnpj;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		
		sb.append(nome);
		sb.append(" - ");
		sb.append(contato);
		sb.append(" - ");
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


