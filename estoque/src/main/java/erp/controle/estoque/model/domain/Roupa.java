package erp.controle.estoque.model.domain;

public class Roupa {
	
	private String descricao;
	private float valor;
	private Boolean disponibilidade;
	private String tamanho;
	
	public Roupa(String descricao, float valor, Boolean disponibilidade, String tamanho) {
		this.descricao = descricao;
		this.valor = valor;
		this.disponibilidade = disponibilidade;
		this.tamanho = tamanho;
	}
	
	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(disponibilidade);
		sb.append(" - ");
		sb.append(descricao);
		sb.append(" - ");
		sb.append(tamanho);
		sb.append(" - ");
		sb.append(valor);
		
		return sb.toString();
	}
}
