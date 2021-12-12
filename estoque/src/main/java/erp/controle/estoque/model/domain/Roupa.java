package erp.controle.estoque.model.domain;

public abstract class Roupa {
	
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
	
	public abstract float calcularValorPedido();
	
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
		sb.append(" - ");
		sb.append(this.calcularValorPedido());
		
		return sb.toString();
	}

	public String getDescricao() {
		return descricao;
	}

	public float getValor() {
		return valor;
	}

	public Boolean getDisponibilidade() {
		return disponibilidade;
	}

	public String getTamanho() {
		return tamanho;
	}
	
	
}
